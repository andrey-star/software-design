package com.andreystar.esourcing.repository;

import com.andreystar.esourcing.event.TurnstileEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurnstileEventRepository extends JpaRepository<TurnstileEvent, Integer> {
    List<TurnstileEvent> findAllByClientId(int clientId);
}
