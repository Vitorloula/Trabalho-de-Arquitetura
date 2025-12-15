package com.healthmonitor.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class VitalSign {

    private UUID id;
    private Double value;
    private String type;
    private String unit;
    private LocalDateTime timestamp;
    private UUID patientId;

    public VitalSign(Double value, String type, String unit, UUID patientId) {
        this.id = UUID.randomUUID();
        this.value = value;
        this.type = type;
        this.unit = unit;
        this.patientId = patientId;
        this.timestamp = LocalDateTime.now();
        validate();
    }

    public VitalSign(UUID id, Double value, String type, String unit, UUID patientId, LocalDateTime timestamp) {
        this.id = id;
        this.value = value;
        this.type = type;
        this.unit = unit;
        this.patientId = patientId;
        this.timestamp = timestamp;
    }

    public void validate() {
        if (value == null || value < 0) {
            throw new IllegalArgumentException("Valor inválido para sinal vital");
        }
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Tipo de sinal vital é obrigatório");
        }
        if (patientId == null) {
            throw new IllegalArgumentException("ID do paciente é obrigatório");
        }
    }

    public boolean isCritical() {
        return switch (type.toUpperCase()) {
            case "HEART_RATE" -> value < 60 || value > 100;
            case "BLOOD_PRESSURE_SYSTOLIC" -> value < 90 || value > 140;
            case "BLOOD_PRESSURE_DIASTOLIC" -> value < 60 || value > 90;
            case "TEMPERATURE" -> value < 35.5 || value > 37.5;
            case "OXYGEN_SATURATION" -> value < 95;
            default -> false;
        };
    }

    public UUID getId() {
        return id;
    }

    public Double getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public String getUnit() {
        return unit;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public UUID getPatientId() {
        return patientId;
    }
}
