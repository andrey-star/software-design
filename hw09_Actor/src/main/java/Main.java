import actor.MasterActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import search.UrlSearchClient;

import static akka.pattern.PatternsCS.ask;

public class Main {

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("MySystem");
        ActorRef master = system.actorOf(Props.create(MasterActor.class, new UrlSearchClient("https://search.com")));

        Object response = ask(master, "query", 10000).toCompletableFuture().join();
        System.out.println(response);

        system.terminate();
    }

}
