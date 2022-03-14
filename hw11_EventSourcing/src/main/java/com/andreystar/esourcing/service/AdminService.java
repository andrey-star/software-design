package com.andreystar.esourcing.service;

import com.andreystar.esourcing.command.ClientCreationRequest;
import com.andreystar.esourcing.command.SubscriptionExtensionRequest;
import com.andreystar.esourcing.event.ClientCreation;
import com.andreystar.esourcing.repository.ClientCreationRepository;
import com.andreystar.esourcing.query.Subscription;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final ClientCreationRepository clientRepository;
    private final SubscriptionService subscriptionService;

    public AdminService(ClientCreationRepository clientRepository, SubscriptionService subscriptionService) {
        this.clientRepository = clientRepository;
        this.subscriptionService = subscriptionService;
    }

    public Integer registerClient(ClientCreationRequest clientCreationRequest) {
        ClientCreation entity = new ClientCreation();
        entity.setName(clientCreationRequest.getName());
        return clientRepository.save(entity).getId();
    }

    public void extendSubscription(SubscriptionExtensionRequest extension) {
        subscriptionService.extendSubscription(extension);
    }

    public Subscription getSubscription(int clientId) {
        ClientCreation client = clientRepository.findById(clientId).orElseThrow();
        return new Subscription(client.getName(), subscriptionService.getSubscriptionEndTime(clientId));
    }

}
