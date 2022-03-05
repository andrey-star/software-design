package entity;

import org.bson.Document;

public class User {
    private final long id;
    private final Currency currency;

    public User(Document document) {
        this(document.getLong("id"),
                Currency.valueOf(document.getString("currency")));
    }

    public User(long id, Currency currency) {
        this.id = id;
        this.currency = currency;
    }

    public Document toDocument() {
        return new Document()
                .append("id", id)
                .append("currency", currency.toString());
    }

    public Currency getCurrency() {
        return currency;
    }
}
