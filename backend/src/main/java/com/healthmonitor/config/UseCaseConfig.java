package com.healthmonitor.config;

import com.healthmonitor.application.gateways.IVitalSignGateway;
import com.healthmonitor.application.usecases.GetPatientVitalsUseCase;
import com.healthmonitor.application.usecases.RegisterVitalSignUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public RegisterVitalSignUseCase registerVitalSignUseCase(IVitalSignGateway gateway) {
        return new RegisterVitalSignUseCase(gateway);
    }

    @Bean
    public GetPatientVitalsUseCase getPatientVitalsUseCase(IVitalSignGateway gateway) {
        return new GetPatientVitalsUseCase(gateway);
    }
}
