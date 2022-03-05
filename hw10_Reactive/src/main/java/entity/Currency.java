package entity;

public enum Currency {
    USD(1),
    EUR(1.09),
    RUB(0.0081);

    public final double toUsd;

    Currency(double toUsd) {
        this.toUsd = toUsd;
    }
}
