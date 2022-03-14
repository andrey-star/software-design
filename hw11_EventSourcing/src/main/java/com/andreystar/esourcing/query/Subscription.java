package com.andreystar.esourcing.query;

import java.time.LocalDateTime;

public class Subscription {
    private final String clientName;
    private final LocalDateTime validThrough;

    public Subscription(String clientName, LocalDateTime validThrough) {
        this.clientName = clientName;
        this.validThrough = validThrough;
    }

    public String getClientName() {
        return clientName;
    }

    public LocalDateTime getvalidThrough() {
        return validThrough;
    }
}
