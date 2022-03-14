package com.andreystar.esourcing.controller;

import com.andreystar.esourcing.command.ClientCreationRequest;
import com.andreystar.esourcing.command.SubscriptionExtensionRequest;
import com.andreystar.esourcing.event.SubscriptionExtension;
import com.andreystar.esourcing.repository.ClientCreationRepository;
import com.andreystar.esourcing.repository.SubscriptionExtensionRepository;
import com.andreystar.esourcing.repository.TurnstileEventRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class TurnstileControllerTest {

    @Autowired
    private AdminController admin;
    @Autowired
    private TurnstileController controller;
    @Autowired
    private TurnstileEventRepository trep;
    @Autowired
    private SubscriptionExtensionRepository srep;
    @Autowired
    private ClientCreationRepository crep;
    private int validClient;
    private int invalidClient;

    @BeforeEach
    public void setUp() {
        validClient = admin.createClient(new ClientCreationRequest("valid"));
        invalidClient = admin.createClient(new ClientCreationRequest("invalid"));
        SubscriptionExtensionRequest ext = new SubscriptionExtensionRequest(validClient, 10);
        admin.extendSubscription(ext);
    }

    @AfterEach
    public void cleanUp() {
        trep.deleteAll();
        srep.deleteAll();
        crep.deleteAll();
    }

    @Test
    public void testIn() {
        assertThatNoException().isThrownBy(() -> controller.in(validClient));
    }

    @Test
    public void testInTwice() {
        controller.in(validClient);
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> controller.in(validClient))
                                                         .withMessage("Already inside");
    }

    @Test
    public void testOut() {
        controller.in(validClient);
        assertThatNoException().isThrownBy(() -> controller.out(validClient));
    }

    @Test
    public void testOutFirst() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> controller.out(validClient))
                                                         .withMessage("Already outside");
    }

    @Test
    public void testOutTwice() {
        controller.in(validClient);
        controller.out(validClient);
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> controller.out(validClient))
                                                         .withMessage("Already outside");
    }

    @Test
    public void testInBad() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> controller.in(invalidClient))
                                                         .withMessage("Subscription ended");
    }

    @Test
    public void testInSubscriptionEnded() {
        SubscriptionExtension entity = new SubscriptionExtension();
        entity.setClientId(invalidClient);
        entity.setDays(4);
        SubscriptionExtension save = srep.save(entity);
        save.setCreated(LocalDateTime.now().minusDays(5));
        srep.save(entity);

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> controller.in(invalidClient))
                                                         .withMessage("Subscription ended");
    }

    @Test
    public void testInSubscriptionEndedAndExtended() {
        SubscriptionExtension entity = new SubscriptionExtension();
        entity.setClientId(invalidClient);
        entity.setDays(4);
        SubscriptionExtension save = srep.save(entity);
        save.setCreated(LocalDateTime.now().minusDays(50));
        srep.save(entity);

        SubscriptionExtensionRequest ext = new SubscriptionExtensionRequest(invalidClient, 4);
        admin.extendSubscription(ext);

        assertThatNoException().isThrownBy(() -> controller.in(invalidClient));
    }
}
