package com.andreystar.account.entity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private long id;

    private double balance;

    @ElementCollection
    @CollectionTable(name = "account_stock_mapping",
            joinColumns = {@JoinColumn(name = "account_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "stock_name")
    private Map<String, Integer> stocks = new HashMap<>();

    public Account(double balance) {
        this.balance = balance;
    }

    public Account() {
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Map<String, Integer> getStocks() {
        return stocks;
    }

    public void setStocks(Map<String, Integer> stocks) {
        this.stocks = stocks;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void addMoney(double money) {
        this.balance += money;
    }

    public void spendMoney(double money) {
        this.balance -= money;
    }
}
