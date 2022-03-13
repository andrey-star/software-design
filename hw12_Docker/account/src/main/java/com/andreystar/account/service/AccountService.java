package com.andreystar.account.service;

import com.andreystar.account.entity.Account;
import com.andreystar.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final MarketService marketService;

    public AccountService(AccountRepository accountRepository, MarketService marketService) {
        this.accountRepository = accountRepository;
        this.marketService = marketService;
    }

    public Account addAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account addMoney(long accountId, double money) {
        Account account = getAccount(accountId);
        account.addMoney(money);
        return accountRepository.save(account);
    }

    public Account buyStocks(long accountId, String company, int stocks) {
        Account account = getAccount(accountId);
        double stockPrice = marketService.getStockPrice(company);
        if (account.getBalance() < stockPrice * stocks) {
            throw new RuntimeException("Not enough money");
        }
        marketService.buyStocks(company, stocks);
        account.getStocks().put(company, account.getStocks().getOrDefault(company, 0) + stocks);
        account.spendMoney(stockPrice * stocks);
        return accountRepository.save(account);
    }

    public Account sellStocks(long accountId, String company, int stocks) {
        Account account = getAccount(accountId);
        int availableStocks = account.getStocks().getOrDefault(company, 0);
        if (availableStocks < stocks) {
            throw new RuntimeException("Not enough stocks");
        }
        double stockPrice = marketService.getStockPrice(company);
        marketService.sellStocks(company, stocks);
        account.getStocks().put(company, account.getStocks().get(company) - stocks);
        account.addMoney(stocks * stockPrice);
        return accountRepository.save(account);
    }

    public Account getAccount(long accountId) {
        return accountRepository.findById(accountId)
                                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public double stockBalance(long accountId) {
        Account account = getAccount(accountId);
        double balance = 0;
        for (var stock : account.getStocks().entrySet()) {
            double stockPrice = marketService.getStockPrice(stock.getKey());
            balance += stockPrice * stock.getValue();
        }
        return balance;
    }
}
