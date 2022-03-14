package com.andreystar.esourcing.repository;

import com.andreystar.esourcing.event.ClientCreation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientCreationRepository extends JpaRepository<ClientCreation, Integer> {
}
