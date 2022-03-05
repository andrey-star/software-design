import com.mongodb.rx.client.MongoClient;
import com.mongodb.rx.client.MongoClients;
import com.mongodb.rx.client.MongoDatabase;
import dao.StoreReactiveDao;
import dao.StoreService;
import http.RequestHandler;
import io.reactivex.netty.protocol.http.server.HttpServer;
import rx.Observable;

public class Main {

    public static void main(String[] args) {
        MongoDatabase db = createMongoClient().getDatabase("reactive");
        RequestHandler requestHandler = new RequestHandler(new StoreService(new StoreReactiveDao(
                db.getCollection("users"), db.getCollection("products"))));

        HttpServer
                .newServer(8080)
                .start((req, resp) -> {
                    Observable<String> response = requestHandler.getResponse(req);
                    return resp.writeString(response);
                })
                .awaitShutdown();
    }

    private static MongoClient createMongoClient() {
        return MongoClients.create("mongodb://localhost:27017");
    }
}
