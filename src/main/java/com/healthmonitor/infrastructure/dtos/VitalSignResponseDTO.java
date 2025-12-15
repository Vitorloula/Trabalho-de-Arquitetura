package com.healthmonitor.infrastructure.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record VitalSignResponseDTO(
                UUID id,
                Double value,
                String type,
                String unit,
                UUID patientId,
                LocalDateTime timestamp,
                boolean critical) {
}
