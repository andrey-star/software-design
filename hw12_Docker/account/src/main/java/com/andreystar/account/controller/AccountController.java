package com.andreystar.account.controller;

import com.andreystar.account.entity.Account;
import com.andreystar.account.service.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/add-account")
    public Account addAccount(@RequestParam double balance) {
        return accountService.addAccount(new Account(balance));
    }

    @PostMapping("/add-money/{id}")
    public Account addMoney(@PathVariable long id, @RequestParam double money) {
        return accountService.addMoney(id, money);
    }

    @GetMapping("/get-account/{id}")
    public Account getAccount(@PathVariable long id) {
        return accountService.getAccount(id);
    }

    @PostMapping("/buy-stocks/{id}")
    public Account buyStocks(@PathVariable long id, @RequestParam String company, @RequestParam int stocks) {
        return accountService.buyStocks(id, company, stocks);
    }

    @PostMapping("/sell-stocks/{id}")
    public Account sellStocks(@PathVariable long id, @RequestParam String company, @RequestParam int stocks) {
        return accountService.sellStocks(id, company, stocks);
    }

    @GetMapping("/stock-balance/{id}")
    public double inStocks(@PathVariable long id) {
        return accountService.stockBalance(id);
    }
}
