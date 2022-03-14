package com.andreystar.esourcing.controller;

import com.andreystar.esourcing.command.ClientCreationRequest;
import com.andreystar.esourcing.command.SubscriptionExtensionRequest;
import com.andreystar.esourcing.event.Direction;
import com.andreystar.esourcing.event.TurnstileEvent;
import com.andreystar.esourcing.query.AverageStatistics;
import com.andreystar.esourcing.repository.ClientCreationRepository;
import com.andreystar.esourcing.repository.SubscriptionExtensionRepository;
import com.andreystar.esourcing.repository.TurnstileEventRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
class ReportControllerTest {
    @Autowired
    private AdminController admin;
    @Autowired
    private ReportController controller;
    @Autowired
    private TurnstileEventRepository trep;
    @Autowired
    private SubscriptionExtensionRepository srep;
    @Autowired
    private ClientCreationRepository crep;
    private int client1;
    private int client2;

    @BeforeEach
    public void setUp() {
        client1 = admin.createClient(new ClientCreationRequest("client1"));
        client2 = admin.createClient(new ClientCreationRequest("client2"));
        SubscriptionExtensionRequest ext = new SubscriptionExtensionRequest(client1, 10);
        admin.extendSubscription(ext);
        ext = new SubscriptionExtensionRequest(client2, 10);
        admin.extendSubscription(ext);
    }

    @AfterEach
    public void cleanUp() {
        trep.deleteAll();
        srep.deleteAll();
        crep.deleteAll();
    }

    @Test
    public void testDayStatistics() {
        addDayVisit(3, client1);
        addDayVisit(3, client2);
        addDayVisit(5, client1);

        Map<LocalDateTime, Integer> stat = controller.getDayStatistics(6);
        assertThat(stat)
                .containsEntry(ago(3), 2)
                .containsEntry(ago(5), 1);
    }

    @Test
    public void testAverageEmpty() {
        AverageStatistics stat = controller.averageStatistics();
        assertThat(stat.getVisitsPerDay()).isEqualTo(0);
        assertThat(stat.getAverageVisitMinutes()).isEqualTo(0);
    }

    @Test
    public void testAverage() {
        addDayVisit(3, client1);
        addDayVisit(3, client2);
        addDayVisit(5, client1);

        AverageStatistics stat = controller.averageStatistics();
        assertThat(stat.getVisitsPerDay()).isEqualTo(3.0 / 5);
        assertThat(stat.getAverageVisitMinutes()).isEqualTo(24 * 60);
    }

    @Test
    public void testAverageCaching() {
        addDayVisit(3, client1);
        addDayVisit(3, client2);
        addDayVisit(5, client1);

        controller.averageStatistics();

        addFastVisit(0, client1);
        addFastVisit(0, client2);
        AverageStatistics stat = controller.averageStatistics();

        assertThat(stat.getVisitsPerDay()).isEqualTo(5.0 / 5);
        assertThat(stat.getAverageVisitMinutes()).isEqualTo(24.0 * 60 * 3 / 5);
    }

    private void addIn(int daysAgo, int clientId) {
        TurnstileEvent entity = new TurnstileEvent();
        entity.setClientId(clientId);
        entity.setDirection(Direction.IN);
        TurnstileEvent save = trep.save(entity);
        save.setCreated(LocalDateTime.now().minusDays(daysAgo));
        trep.save(save);
    }

    private void addOut(int daysAgo, int clientId) {
        TurnstileEvent entity = new TurnstileEvent();
        entity.setClientId(clientId);
        entity.setDirection(Direction.OUT);
        TurnstileEvent save = trep.save(entity);
        save.setCreated(LocalDateTime.now().minusDays(daysAgo));
        trep.save(save);
    }

    private void addFastVisit(int daysAgo, int clientId) {
        addIn(daysAgo, clientId);
        addOut(daysAgo, clientId);
    }

    private void addDayVisit(int daysAgo, int clientId) {
        addIn(daysAgo, clientId);
        addOut(daysAgo - 1, clientId);
    }

    private LocalDateTime ago(int days) {
        return LocalDateTime.now().minusDays(days).withHour(0).withMinute(0).withSecond(0).withNano(0);
    }
}
