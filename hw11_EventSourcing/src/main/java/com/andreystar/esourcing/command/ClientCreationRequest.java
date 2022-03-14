package com.andreystar.esourcing.command;

public class ClientCreationRequest {
    private final String name;

    public ClientCreationRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
