package com.andreystar.market.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Company {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private int stocks;
    private double stockPrice;

    public Company() {
    }

    public Company(String name, int stocks, double stockPrice) {
        this.name = name;
        this.stocks = stocks;
        this.stockPrice = stockPrice;
    }

    public void addStocks(int stocks) {
        this.stocks += stocks;
    }

    public void buyStocks(int stocks) {
        if (this.stocks < stocks) {
            throw new RuntimeException("Not enough stocks");
        }
        this.stocks -= stocks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStocks() {
        return stocks;
    }

    public void setStocks(int stocks) {
        this.stocks = stocks;
    }

    public double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
