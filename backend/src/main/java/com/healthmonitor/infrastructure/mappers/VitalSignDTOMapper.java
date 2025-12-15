package com.healthmonitor.infrastructure.mappers;

import com.healthmonitor.domain.entities.VitalSign;
import com.healthmonitor.infrastructure.dtos.VitalSignRequestDTO;
import com.healthmonitor.infrastructure.dtos.VitalSignResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class VitalSignDTOMapper {

    public VitalSign toDomain(VitalSignRequestDTO dto) {
        return new VitalSign(dto.value(), dto.type(), dto.unit(), dto.patientId());
    }

    public VitalSignResponseDTO toDTO(VitalSign domain) {
        return new VitalSignResponseDTO(
                domain.getId(),
                domain.getValue(),
                domain.getType(),
                domain.getUnit(),
                domain.getPatientId(),
                domain.getTimestamp(),
                domain.isCritical());
    }
}
