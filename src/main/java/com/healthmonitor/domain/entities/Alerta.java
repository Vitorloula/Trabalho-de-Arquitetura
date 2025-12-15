package com.healthmonitor.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class Alerta {

    private UUID id;
    private String mensagem;
    private NivelSeveridade severidade;
    private UUID pacienteId;
    private LocalDateTime criadoEm;
    private boolean lido;

    public Alerta(String mensagem, NivelSeveridade severidade, UUID pacienteId) {
        this.id = UUID.randomUUID();
        this.mensagem = mensagem;
        this.severidade = severidade;
        this.pacienteId = pacienteId;
        this.criadoEm = LocalDateTime.now();
        this.lido = false;
    }

    public Alerta(UUID id, String mensagem, NivelSeveridade severidade, UUID pacienteId, LocalDateTime criadoEm,
            boolean lido) {
        this.id = id;
        this.mensagem = mensagem;
        this.severidade = severidade;
        this.pacienteId = pacienteId;
        this.criadoEm = criadoEm;
        this.lido = lido;
    }

    public void marcarComoLido() {
        this.lido = true;
    }

    public UUID getId() {
        return id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public NivelSeveridade getSeveridade() {
        return severidade;
    }

    public UUID getPacienteId() {
        return pacienteId;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public boolean isLido() {
        return lido;
    }
}
