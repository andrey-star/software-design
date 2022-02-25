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
import search.UrlSearchClient;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static akka.pattern.PatternsCS.ask;
import static com.xebialabs.restito.builder.stub.StubHttp.whenHttp;
import static com.xebialabs.restito.semantics.Action.stringContent;
import static com.xebialabs.restito.semantics.Action.delay;
import static com.xebialabs.restito.semantics.Condition.method;
import static com.xebialabs.restito.semantics.Condition.startsWithUri;
import static org.assertj.core.api.Assertions.assertThat;

class MasterActorTest {

    private ActorSystem system;
    private ActorRef master;
    private static final int PORT = 32453;

    @BeforeEach
    public void setUp() {
        system = ActorSystem.create("MasterActorTest");
        master = system.actorOf(Props.create(MasterActor.class, new UrlSearchClient("http://localhost:" + PORT)));
    }

    @AfterEach
    public void tearDown() {
        system.terminate();
    }

    @Test
    public void allSuccessful() {
        withStubServer(s -> {
            whenHttp(s).match(method(Method.GET), startsWithUri("/google"))
                       .then(stringContent(toJson("g1", "g2", "g3")));
            whenHttp(s).match(method(Method.GET), startsWithUri("/bing"))
                       .then(stringContent(toJson("b1", "b2", "b3")));
            whenHttp(s).match(method(Method.GET), startsWithUri("/yandex"))
                       .then(stringContent(toJson("y1", "y2", "y3")));

            var response = (Map<Engine, List<String>>) ask(master, "query", 10000).toCompletableFuture().join();

            assertThat(response).size().isEqualTo(3);
            assertThat(response).containsEntry(Engine.GOOGLE, List.of("g1", "g2", "g3"));
            assertThat(response).containsEntry(Engine.BING, List.of("b1", "b2", "b3"));
            assertThat(response).containsEntry(Engine.YANDEX, List.of("y1", "y2", "y3"));
        });
    }

    @Test
    public void withFailures() {
        withStubServer(s -> {
            whenHttp(s).match(method(Method.GET), startsWithUri("/google"))
                       .then(stringContent(toJson("g1", "g2", "g3")));
            whenHttp(s).match(method(Method.GET), startsWithUri("/bing"))
                       .then(delay(1500), stringContent(toJson("b1", "b2", "b3")));
            whenHttp(s).match(method(Method.GET), startsWithUri("/yandex"))
                       .then(stringContent(toJson("y1", "y2", "y3")));

            var response = (Map<Engine, List<String>>) ask(master, "query", 10000).toCompletableFuture().join();

            assertThat(response).doesNotContainKey(Engine.BING);
        });
    }

    private void withStubServer(Consumer<StubServer> callback) {
        StubServer stubServer = null;
        try {
            stubServer = new StubServer(MasterActorTest.PORT).run();
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
