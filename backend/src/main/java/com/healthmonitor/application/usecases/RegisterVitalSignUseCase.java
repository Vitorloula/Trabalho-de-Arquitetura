package com.healthmonitor.application.usecases;

import com.healthmonitor.application.gateways.IVitalSignGateway;
import com.healthmonitor.domain.entities.VitalSign;

public class RegisterVitalSignUseCase {

    private final IVitalSignGateway gateway;

    public RegisterVitalSignUseCase(IVitalSignGateway gateway) {
        this.gateway = gateway;
    }

    public VitalSign execute(VitalSign vitalSign) {
        vitalSign.validate();
        return gateway.save(vitalSign);
    }
}
