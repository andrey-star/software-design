package actor;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.ReceiveTimeout;
import akka.actor.UntypedActor;
import scala.concurrent.duration.Duration;
import search.Engine;
import search.Request;
import search.Response;
import search.SearchClient;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MasterActor extends UntypedActor {

    private final SearchClient searchClient;
    private final Map<Engine, List<String>> results = new HashMap<>();
    private ActorRef parent;

    public MasterActor(SearchClient searchClient) {
        this.searchClient = searchClient;
    }

    @Override
    public void onReceive(Object o) {
        if (o instanceof String query) {
            parent = getSender();
            for (Engine searchEngine : Engine.values()) {
                ActorRef childRef = getContext().actorOf(Props.create(ChildActor.class, searchClient));
                childRef.tell(new Request(searchEngine, query), self());
            }
            getContext().setReceiveTimeout(Duration.create(1, TimeUnit.SECONDS));
        } else if (o instanceof Response response) {
            results.put(response.engine(), response.results());
            if (Arrays.stream(Engine.values()).allMatch(results::containsKey)) {
                parent.tell(results, self());
                getContext().stop(self());
            }
        } else if (o instanceof ReceiveTimeout) {
            parent.tell(results, self());
            getContext().stop(self());
        }
    }
}
