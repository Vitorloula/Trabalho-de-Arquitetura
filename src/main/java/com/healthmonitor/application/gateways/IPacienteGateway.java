package com.healthmonitor.application.gateways;

import com.healthmonitor.domain.entities.Paciente;
import java.util.Optional;
import java.util.UUID;

public interface IPacienteGateway {
    Paciente save(Paciente paciente);

    Optional<Paciente> findById(UUID id);

    Optional<Paciente> findByEmail(String email);
}
