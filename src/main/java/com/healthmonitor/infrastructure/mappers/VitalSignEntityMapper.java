package com.healthmonitor.infrastructure.mappers;

import com.healthmonitor.domain.entities.VitalSign;
import com.healthmonitor.infrastructure.persistence.entities.VitalSignJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class VitalSignEntityMapper {

    public VitalSignJpaEntity toJpa(VitalSign domain) {
        return new VitalSignJpaEntity(
                domain.getId(),
                domain.getValue(),
                domain.getType(),
                domain.getUnit(),
                domain.getPatientId(),
                domain.getTimestamp());
    }

    public VitalSign toDomain(VitalSignJpaEntity entity) {
        return new VitalSign(
                entity.getId(),
                entity.getValue(),
                entity.getType(),
                entity.getUnit(),
                entity.getPatientId(),
                entity.getTimestamp());
    }
}
