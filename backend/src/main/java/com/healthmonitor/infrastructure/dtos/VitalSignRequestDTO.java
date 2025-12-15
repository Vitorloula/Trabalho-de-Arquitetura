package com.healthmonitor.infrastructure.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.UUID;

public record VitalSignRequestDTO(
                @NotNull(message = "Valor é obrigatório") @Positive(message = "Valor deve ser positivo") Double value,

                @NotBlank(message = "Tipo é obrigatório") String type,

                String unit,

                @NotNull(message = "ID do paciente é obrigatório") UUID patientId) {
}
