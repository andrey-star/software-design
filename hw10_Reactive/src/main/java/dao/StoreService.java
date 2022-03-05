package dao;

import entity.Currency;
import entity.Product;
import entity.User;
import rx.Observable;

public class StoreService {

    private final StoreReactiveDao dao;

    public StoreService(StoreReactiveDao dao) {
        this.dao = dao;
    }

    public Observable<String> getLocalProductsForUser(long userId) {
        Observable<Currency> currency = dao.getUser(userId).map(User::getCurrency);
        Observable<Product> products = dao.getProducts();
        return Observable.combineLatest(currency, products, (cur, product) -> product.toString(cur));
    }

    public Observable<String> addUser(long userId, Currency currency) {
        return dao.addUser(new User(userId, currency));
    }

    public Observable<String> addProduct(long userId, long price, String name) {
        return dao.getUser(userId)
                  .map(User::getCurrency)
                  .switchMap(currency -> dao.addProduct(new Product(name, price, currency)));
    }
}
