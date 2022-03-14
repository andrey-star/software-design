package com.andreystar.esourcing.command;

public class SubscriptionExtensionRequest {
    private final int clientId;
    private final int days;

    public SubscriptionExtensionRequest(int clientId, int days) {
        this.clientId = clientId;
        this.days = days;
    }

    public int getClientId() {
        return clientId;
    }

    public int getDays() {
        return days;
    }
}
