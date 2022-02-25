package actor;

import akka.actor.UntypedActor;
import search.Request;
import search.SearchClient;

public class ChildActor extends UntypedActor {
    private final SearchClient searchClient;

    public ChildActor(SearchClient searchClient) {
        this.searchClient = searchClient;
    }

    @Override
    public void onReceive(Object o) {
        if (o instanceof Request r) {
            getSender().tell(searchClient.search(r), self());
            getContext().stop(self());
        }
    }
}
