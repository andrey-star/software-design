package actor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.xebialabs.restito.server.StubServer;
import org.glassfish.grizzly.http.Method;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import search.Engine;
import search.Request;
import search.Response;
import search.UrlSearchClient;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static akka.pattern.PatternsCS.ask;
import static com.xebialabs.restito.builder.stub.StubHttp.whenHttp;
import static com.xebialabs.restito.semantics.Action.stringContent;
import static com.xebialabs.restito.semantics.Condition.method;
import static com.xebialabs.restito.semantics.Condition.startsWithUri;
import static org.assertj.core.api.Assertions.assertThat;

class ChildActorTest {

    private ActorSystem system;
    private ActorRef child;
    private static final int PORT = 32453;

    @BeforeEach
    public void setUp() {
        system = ActorSystem.create("MasterActorTest");
        child = system.actorOf(Props.create(ChildActor.class, new UrlSearchClient("http://localhost:" + PORT)));
    }

    @AfterEach
    public void tearDown() {
        system.terminate();
    }

    @Test
    public void successful() {
        withStubServer(s -> {
            whenHttp(s).match(method(Method.GET), startsWithUri("/google"))
                       .then(stringContent(toJson("g1", "g2", "g3")));

            var response = (Response) ask(child, new Request(Engine.GOOGLE, "test"), 10000)
                    .toCompletableFuture()
                    .join();

            assertThat(response.engine()).isEqualTo(Engine.GOOGLE);
            assertThat(response.results()).isEqualTo(List.of("g1", "g2", "g3"));
        });
    }

    private void withStubServer(Consumer<StubServer> callback) {
        StubServer stubServer = null;
        try {
            stubServer = new StubServer(ChildActorTest.PORT).run();
            callback.accept(stubServer);
        } finally {
            if (stubServer != null) {
                stubServer.stop();
            }
        }
    }

    private String toJson(String... ss) {
        return Arrays.stream(ss)
                     .map(s -> "\"" + s + "\"")
                     .collect(Collectors.joining(",", "[", "]"));
    }
}
