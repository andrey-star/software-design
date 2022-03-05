package http;

import dao.StoreService;
import entity.Currency;
import io.netty.buffer.ByteBuf;
import io.reactivex.netty.protocol.http.server.HttpServerRequest;
import rx.Observable;

import java.util.List;

public class RequestHandler {

    private final StoreService service;

    public RequestHandler(StoreService service) {
        this.service = service;
    }

    public Observable<String> getResponse(HttpServerRequest<ByteBuf> req) {
        if (req.getDecodedPath().equals("/products")) {
            return handleGetProducts(req);
        }
        if (req.getDecodedPath().equals("/register")) {
            return handleRegister(req);
        }
        if (req.getDecodedPath().equals("/add-product")) {
            return handleAddProduct(req);
        }
        return Observable.just(req.getDecodedPath());
    }

    private Observable<String> handleGetProducts(HttpServerRequest<ByteBuf> req) {
        long userId = Long.parseLong(getQueryParam(req, "id"));
        return service.getLocalProductsForUser(userId);
    }

    private Observable<String> handleRegister(HttpServerRequest<ByteBuf> req) {
        long userId = Long.parseLong(getQueryParam(req, "id"));
        Currency currency = Currency.valueOf(getQueryParam(req, "currency"));
        return service.addUser(userId, currency);
    }

    private Observable<String> handleAddProduct(HttpServerRequest<ByteBuf> req) {
        long userId = Long.parseLong(getQueryParam(req, "id"));
        long price = Long.parseLong(getQueryParam(req, "price"));
        String name = getQueryParam(req, "name");
        return service.addProduct(userId, price, name);
    }

    private String getQueryParam(HttpServerRequest<ByteBuf> req, String key) {
        List<String> values = req.getQueryParameters().get(key);
        if (values.isEmpty()) {
            throw new RuntimeException("No username provided");
        }
        return values.get(0);
    }

}
