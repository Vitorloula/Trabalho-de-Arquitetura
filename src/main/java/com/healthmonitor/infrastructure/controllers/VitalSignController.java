package com.healthmonitor.infrastructure.controllers;

import com.healthmonitor.application.usecases.GetPatientVitalsUseCase;
import com.healthmonitor.application.usecases.RegisterVitalSignUseCase;
import com.healthmonitor.domain.entities.VitalSign;
import com.healthmonitor.infrastructure.dtos.VitalSignRequestDTO;
import com.healthmonitor.infrastructure.dtos.VitalSignResponseDTO;
import com.healthmonitor.infrastructure.mappers.VitalSignDTOMapper;
import com.healthmonitor.application.gateways.IVitalSignGateway;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/vitals")
@CrossOrigin(origins = "*")
public class VitalSignController {

    private final RegisterVitalSignUseCase registerUseCase;
    private final GetPatientVitalsUseCase getVitalsUseCase;
    private final VitalSignDTOMapper mapper;
    private final IVitalSignGateway gateway;

    public VitalSignController(
            RegisterVitalSignUseCase registerUseCase,
            GetPatientVitalsUseCase getVitalsUseCase,
            VitalSignDTOMapper mapper,
            IVitalSignGateway gateway) {
        this.registerUseCase = registerUseCase;
        this.getVitalsUseCase = getVitalsUseCase;
        this.mapper = mapper;
        this.gateway = gateway;
    }

    @GetMapping
    public ResponseEntity<List<VitalSignResponseDTO>> getAll() {
        List<VitalSign> vitals = gateway.findAll();
        List<VitalSignResponseDTO> response = vitals.stream().map(mapper::toDTO).toList();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<VitalSignResponseDTO> create(@Valid @RequestBody VitalSignRequestDTO request) {
        VitalSign domain = mapper.toDomain(request);
        VitalSign saved = registerUseCase.execute(domain);
        VitalSignResponseDTO response = mapper.toDTO(saved);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<VitalSignResponseDTO>> getByPatient(@PathVariable UUID patientId) {
        List<VitalSign> vitals = getVitalsUseCase.execute(patientId);
        List<VitalSignResponseDTO> response = vitals.stream().map(mapper::toDTO).toList();
        return ResponseEntity.ok(response);
    }
}
