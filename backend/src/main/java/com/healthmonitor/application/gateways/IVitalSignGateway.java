package com.healthmonitor.application.gateways;

import com.healthmonitor.domain.entities.VitalSign;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IVitalSignGateway {
    VitalSign save(VitalSign vitalSign);

    Optional<VitalSign> findById(UUID id);

    List<VitalSign> findAllByPatientId(UUID patientId);

    List<VitalSign> findAll();

    void deleteById(UUID id);
}
