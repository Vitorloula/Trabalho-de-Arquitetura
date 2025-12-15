package com.healthmonitor.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class Paciente {

    private UUID id;
    private String nome;
    private String email;
    private String cpf;
    private LocalDateTime dataCadastro;

    public Paciente(String nome, String email, String cpf) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataCadastro = LocalDateTime.now();
        validate();
    }

    public Paciente(UUID id, String nome, String email, String cpf, LocalDateTime dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataCadastro = dataCadastro;
    }

    public void validate() {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }
}
