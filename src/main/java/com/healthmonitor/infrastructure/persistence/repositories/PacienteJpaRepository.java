package com.healthmonitor.infrastructure.persistence.repositories;

import com.healthmonitor.infrastructure.persistence.entities.PacienteJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PacienteJpaRepository extends JpaRepository<PacienteJpaEntity, UUID> {
    Optional<PacienteJpaEntity> findByEmail(String email);
}
