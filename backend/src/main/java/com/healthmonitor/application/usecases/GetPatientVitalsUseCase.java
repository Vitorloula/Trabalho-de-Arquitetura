package com.healthmonitor.application.usecases;

import com.healthmonitor.application.gateways.IVitalSignGateway;
import com.healthmonitor.domain.entities.VitalSign;
import java.util.List;
import java.util.UUID;

public class GetPatientVitalsUseCase {

    private final IVitalSignGateway gateway;

    public GetPatientVitalsUseCase(IVitalSignGateway gateway) {
        this.gateway = gateway;
    }

    public List<VitalSign> execute(UUID patientId) {
        return gateway.findAllByPatientId(patientId);
    }
}
