package com.healthmonitor.infrastructure.persistence.repositories;

import com.healthmonitor.infrastructure.persistence.entities.VitalSignJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface VitalSignJpaRepository extends JpaRepository<VitalSignJpaEntity, UUID> {
    List<VitalSignJpaEntity> findByPatientIdOrderByTimestampDesc(UUID patientId);
}
