package com.andreystar.account.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class MarketService {

    private final String HOST = "http://localhost:8080/market";
    private final RestTemplate restTemplate;

    public MarketService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void buyStocks(String name, int stocks) {
        restTemplate.postForObject(HOST + "/buy-stocks/{name}?stocks={stocks}", null, String.class, name, stocks);
    }

    public void sellStocks(String name, int stocks) {
        restTemplate.postForObject(HOST + "/add-stocks/{name}?stocks={stocks}", null, String.class, name, stocks);
    }

    public double getStockPrice(String name) {
        Map<String, Object> response = restTemplate.getForObject(HOST + "/get-company/{name}", HashMap.class, name);
        return (double) response.get("stockPrice");
    }
}
