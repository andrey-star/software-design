package com.andreystar.account.controller;

import com.andreystar.account.entity.Account;

import com.andreystar.account.repository.AccountRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.testcontainers.containers.FixedHostPortGenericContainer;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest
@Transactional
public class AccountControllerTest {

    @Autowired
    private AccountController controller;
    @Autowired
    private AccountRepository repository;

    private final TestRestTemplate restTemplate = new TestRestTemplate();
    private long accountId;

    private final String MARKET_HOST = "http://localhost:8080/market";

    @Container
    public static GenericContainer market
            = new FixedHostPortGenericContainer("market:1.0-SNAPSHOT")
            .withFixedExposedPort(8080, 8080)
            .withExposedPorts(8080);

    @BeforeEach
    public void setUp() {
        market.start();
        addCompany("PigNewton", 10000, 20);
        accountId = controller.addAccount(1000).getId();
    }

    @AfterEach
    public void cleanUp() {
        market.stop();
    }

    @Test
    public void testRegister() {
        Account res = controller.getAccount(accountId);
        assertThat(res.getBalance()).isEqualTo(1000);
        assertThat(res.getStocks()).isEmpty();
    }

    @Test
    public void testAddMoney() {
        Account res = controller.addMoney(accountId, 1000);
        assertThat(res.getBalance()).isEqualTo(2000);
        assertThat(res.getStocks()).isEmpty();
    }

    @Test
    public void testBuyStocks() {
        Account res = controller.buyStocks(accountId, "PigNewton", 10);
        assertThat(res.getBalance()).isEqualTo(1000 - 10 * 20);
        assertThat(res.getStocks()).containsEntry("PigNewton", 10);
        assertThat(controller.inStocks(accountId)).isEqualTo(10 * 20);
    }

    @Test
    public void testBuyStocksAfterPriceChange() {
        controller.buyStocks(accountId, "PigNewton", 10);
        changePrice("PigNewton", 50);
        Account res = controller.buyStocks(accountId, "PigNewton", 10);
        assertThat(res.getBalance()).isEqualTo(1000 - 10 * 20 - 10 * 50);
        assertThat(res.getStocks()).containsEntry("PigNewton", 20);
        assertThat(controller.inStocks(accountId)).isEqualTo(20 * 50);
    }

    @Test
    public void testBuySellIncrease() {
        controller.buyStocks(accountId, "PigNewton", 10);
        changePrice("PigNewton", 50);
        Account res = controller.sellStocks(accountId, "PigNewton", 10);
        assertThat(res.getBalance()).isEqualTo(1000 - 10 * 20 + 10 * 50);
        assertThat(res.getStocks()).containsEntry("PigNewton", 0);
        assertThat(controller.inStocks(accountId)).isEqualTo(0);
    }

    private void addCompany(String name, int stocks, double price) {
        restTemplate.postForObject(MARKET_HOST + "/add-company?name={name}&stocks={stocks}&price={price}",
                null, String.class, name, stocks, price);
    }

    private void changePrice(String name, double price) {
        restTemplate.postForObject(MARKET_HOST + "/update-price/{name}?price={price}",
                null, String.class, name, price);
    }
}
