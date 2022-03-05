package entity;

import org.bson.Document;

public class Product {
    private final String name;
    private final double usdPrice;

    public Product(Document document) {
        this(document.getString("name"), document.getDouble("usdPrice"));
    }

    public Product(String name, double usdPrice) {
        this.name = name;
        this.usdPrice = usdPrice;
    }

    public Product(String name, long price, Currency currency) {
        this(name, toUsd(price, currency));
    }

    private static double toUsd(long price, Currency currency) {
        return price * currency.toUsd;
    }

    public Document toDocument() {
        return new Document()
                .append("name", name)
                .append("usdPrice", usdPrice);
    }

    public String toString(Currency currency) {
        return formatProduct(1 / currency.toUsd, currency.toString());
    }

    private String formatProduct(double priceCoef, String currencyStr) {
        return String.format("%s %.2f %s%n", name, usdPrice * priceCoef, currencyStr);
    }
}
