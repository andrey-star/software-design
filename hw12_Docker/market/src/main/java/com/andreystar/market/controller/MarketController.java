package com.andreystar.market.controller;

import com.andreystar.market.entity.Company;
import com.andreystar.market.service.MarketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/market")
public class MarketController {

    private final MarketService marketService;

    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @PostMapping("/add-company")
    public Company addCompany(@RequestParam String name, @RequestParam int stocks, @RequestParam double price) {
        return marketService.addCompany(new Company(name, stocks, price));
    }

    @PostMapping("/add-stocks/{name}")
    public Company addStocks(@PathVariable String name, @RequestParam int stocks) {
        return marketService.addStocks(name, stocks);
    }

    @GetMapping("/get-companies")
    public List<Company> getCompany() {
        return marketService.getCompanies();
    }

    @GetMapping("/get-company/{name}")
    public Company getCompany(@PathVariable String name) {
        return marketService.getCompany(name);
    }

    @PostMapping("/buy-stocks/{name}")
    public Company buyStocks(@PathVariable String name, @RequestParam int stocks) {
        return marketService.buyStocks(name, stocks);
    }

    @PostMapping("/update-price/{name}")
    public Company updateStockPrice(@PathVariable String name, @RequestParam double price) {
        return marketService.updateStockPrice(name, price);
    }
}
