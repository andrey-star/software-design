package dao;

import com.mongodb.client.model.Filters;
import com.mongodb.rx.client.MongoCollection;
import entity.Product;
import entity.User;
import org.bson.Document;
import rx.Observable;

public class StoreReactiveDao {

    private final MongoCollection<Document> users;
    private final MongoCollection<Document> products;

    public StoreReactiveDao(MongoCollection<Document> users, MongoCollection<Document> products) {
        this.users = users;
        this.products = products;
    }

    public Observable<String> addUser(User user) {
        return addToCollection(users, user.toDocument());
    }

    public Observable<String> addProduct(Product product) {
        return addToCollection(products, product.toDocument());
    }

    public Observable<User> getUser(long userId) {
        return users.find(Filters.eq("id", userId)).first().map(User::new);
    }

    public Observable<Product> getProducts() {
        return products.find().toObservable().map(Product::new);
    }

    private Observable<String> addToCollection(MongoCollection<Document> collection, Document document) {
        return collection.insertOne(document).map(s -> s == null ? "error" : "success");
    }
}
