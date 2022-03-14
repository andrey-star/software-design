package com.andreystar.esourcing.service;

import com.andreystar.esourcing.command.SubscriptionExtensionRequest;
import com.andreystar.esourcing.event.SubscriptionExtension;
import com.andreystar.esourcing.repository.SubscriptionExtensionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class SubscriptionService {

    private final SubscriptionExtensionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionExtensionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public void extendSubscription(SubscriptionExtensionRequest extension) {
        SubscriptionExtension entity = new SubscriptionExtension();
        entity.setClientId(extension.getClientId());
        entity.setDays(extension.getDays());
        subscriptionRepository.save(entity);
    }

    public LocalDateTime getSubscriptionEndTime(int clientId) {
        List<SubscriptionExtension> extensions = subscriptionRepository.findAllByClientId(clientId);
        if (extensions.isEmpty()) {
            return null;
        }

        extensions.sort(Comparator.comparing(SubscriptionExtension::getCreated));
        SubscriptionExtension first = extensions.get(0);
        LocalDateTime res = first.getCreated().plusDays(first.getDays());
        for (int i = 1; i < extensions.size(); i++) {
            SubscriptionExtension curExt = extensions.get(i);
            LocalDateTime curStart = curExt.getCreated();
            if (curStart.isAfter(res)) {
                res = curStart.plusDays(curExt.getDays());
            } else {
                res = res.plusDays(curExt.getDays());
            }
        }
        return res;
    }
}
