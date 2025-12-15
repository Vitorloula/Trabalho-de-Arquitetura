package com.healthmonitor.infrastructure.gateways;

import com.healthmonitor.application.gateways.IVitalSignGateway;
import com.healthmonitor.domain.entities.VitalSign;
import com.healthmonitor.infrastructure.mappers.VitalSignEntityMapper;
import com.healthmonitor.infrastructure.persistence.entities.VitalSignJpaEntity;
import com.healthmonitor.infrastructure.persistence.repositories.VitalSignJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VitalSignGatewayImpl implements IVitalSignGateway {

    private final VitalSignJpaRepository jpaRepository;
    private final VitalSignEntityMapper mapper;

    public VitalSignGatewayImpl(VitalSignJpaRepository jpaRepository, VitalSignEntityMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public VitalSign save(VitalSign vitalSign) {
        VitalSignJpaEntity entity = mapper.toJpa(vitalSign);
        VitalSignJpaEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<VitalSign> findById(UUID id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<VitalSign> findAllByPatientId(UUID patientId) {
        return jpaRepository.findByPatientIdOrderByTimestampDesc(patientId)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<VitalSign> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepository.deleteById(id);
    }
}
