package com.healthmonitor.infrastructure.persistence.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_sinais_vitais")
public class VitalSignJpaEntity {

    @Id
    private UUID id;

    @Column(name = "vital_value", nullable = false)
    private Double value;

    @Column(nullable = false, length = 50)
    private String type;

    @Column(length = 20)
    private String unit;

    @Column(name = "patient_id", nullable = false)
    private UUID patientId;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime timestamp;

    public VitalSignJpaEntity() {
    }

    public VitalSignJpaEntity(UUID id, Double value, String type, String unit, UUID patientId,
            LocalDateTime timestamp) {
        this.id = id;
        this.value = value;
        this.type = type;
        this.unit = unit;
        this.patientId = patientId;
        this.timestamp = timestamp;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
