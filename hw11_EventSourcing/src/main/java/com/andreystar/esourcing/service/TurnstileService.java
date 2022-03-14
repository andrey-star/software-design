package com.andreystar.esourcing.service;

import com.andreystar.esourcing.event.Direction;
import com.andreystar.esourcing.event.TurnstileEvent;
import com.andreystar.esourcing.repository.TurnstileEventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class TurnstileService {

    private final TurnstileEventRepository turnstileEventRepository;
    private final SubscriptionService subscriptionService;

    public TurnstileService(TurnstileEventRepository turnstileEventRepository, SubscriptionService subscriptionService) {
        this.turnstileEventRepository = turnstileEventRepository;
        this.subscriptionService = subscriptionService;
    }

    public void letIn(int clientId) {
        LocalDateTime end = subscriptionService.getSubscriptionEndTime(clientId);
        if (end == null || end.isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Subscription ended");
        }
        List<TurnstileEvent> events = turnstileEventRepository.findAllByClientId(clientId);
        events.sort(Comparator.comparing(TurnstileEvent::getCreated).reversed());
        if (!events.isEmpty() && events.get(0).getDirection() == Direction.IN) {
            throw new RuntimeException("Already inside");
        }
        TurnstileEvent entity = new TurnstileEvent();
        entity.setDirection(Direction.IN);
        entity.setClientId(clientId);
        turnstileEventRepository.save(entity);
    }

    public void letOut(int clientId) {
        List<TurnstileEvent> events = turnstileEventRepository.findAllByClientId(clientId);
        events.sort(Comparator.comparing(TurnstileEvent::getCreated).reversed());
        if (events.isEmpty() || events.get(0).getDirection() == Direction.OUT) {
            throw new RuntimeException("Already outside");
        }
        TurnstileEvent entity = new TurnstileEvent();
        entity.setDirection(Direction.OUT);
        entity.setClientId(clientId);
        turnstileEventRepository.save(entity);
    }
}
