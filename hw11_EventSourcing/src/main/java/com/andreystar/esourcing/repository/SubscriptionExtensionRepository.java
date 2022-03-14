package com.andreystar.esourcing.repository;

import com.andreystar.esourcing.event.SubscriptionExtension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionExtensionRepository extends JpaRepository<SubscriptionExtension, Integer> {
    List<SubscriptionExtension> findAllByClientId(int clientId);
}
