package com.andreystar.esourcing.controller;

import com.andreystar.esourcing.command.ClientCreationRequest;
import com.andreystar.esourcing.command.SubscriptionExtensionRequest;
import com.andreystar.esourcing.event.SubscriptionExtension;
import com.andreystar.esourcing.query.Subscription;
import com.andreystar.esourcing.repository.SubscriptionExtensionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AdminControllerTest {

    @Autowired
    private AdminController controller;
    @Autowired
    private SubscriptionExtensionRepository srepo;

    @Test
    public void createClient() {
        int clientId = controller.createClient(new ClientCreationRequest("hello"));

        Subscription subscription = controller.getSubscription(clientId);
        assertThat(subscription.getClientName()).isEqualTo("hello");
        assertThat(subscription.getvalidThrough()).isNull();
    }

    @Test
    public void testExtendSubscription() {
        LocalDateTime now = LocalDateTime.now();
        int clientId = controller.createClient(new ClientCreationRequest("hello"));
        SubscriptionExtensionRequest ext = new SubscriptionExtensionRequest(clientId, 10);
        controller.extendSubscription(ext);

        Subscription subscription = controller.getSubscription(clientId);
        assertThat(subscription.getvalidThrough()).isAfter(now.plusDays(10));
        assertThat(subscription.getvalidThrough()).isBefore(now.plusDays(11));
    }

    @Test
    public void testExtendSubscriptionTwice() {
        LocalDateTime now = LocalDateTime.now();
        int clientId = controller.createClient(new ClientCreationRequest("hello"));
        SubscriptionExtensionRequest ext = new SubscriptionExtensionRequest(clientId, 10);
        controller.extendSubscription(ext);
        controller.extendSubscription(ext);

        Subscription subscription = controller.getSubscription(clientId);
        assertThat(subscription.getvalidThrough()).isAfter(now.plusDays(20));
        assertThat(subscription.getvalidThrough()).isBefore(now.plusDays(21));
    }

    @Test
    public void testExtendSubscriptionAfterEnded() {
        LocalDateTime now = LocalDateTime.now();
        int clientId = controller.createClient(new ClientCreationRequest("hello"));

        // Add old subscription
        SubscriptionExtension entity = new SubscriptionExtension();
        entity.setId(0);
        entity.setClientId(clientId);
        entity.setDays(20);
        SubscriptionExtension save = srepo.save(entity);
        save.setCreated(LocalDateTime.now().minusDays(50));
        srepo.save(save);

        // Extend by 10 days
        SubscriptionExtensionRequest ext = new SubscriptionExtensionRequest(clientId, 10);
        controller.extendSubscription(ext);

        Subscription subscription = controller.getSubscription(clientId);
        assertThat(subscription.getvalidThrough()).isAfter(now.plusDays(10));
        assertThat(subscription.getvalidThrough()).isBefore(now.plusDays(11));
    }

}
