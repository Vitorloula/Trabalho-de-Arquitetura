# C4 - Nível 2: Diagrama de Contêineres

## HealthMonitor Containers

```mermaid
C4Container
    title Nível 2: Contêineres - HealthMonitor

    Person(paciente, "Paciente", "Usa o navegador")
    Person(medico, "Médico", "Usa o navegador")

    Container_Boundary(boundary, "Ambiente HealthMonitor") {
        Container(webApp, "Single Page Application (SPA)", "React.js + TypeScript", "Interface do usuário responsiva. Gerencia estado visual e chamadas à API.")

        Container(apiApp, "API Backend", "Java 21 + Spring Boot 3", "Implementa a Clean Architecture. Expõe endpoints REST, valida regras de domínio e gerencia segurança.")

        ContainerDb(database, "Banco de Dados", "PostgreSQL", "Armazena tabelas relacionais: Pacientes, SinaisVitais, Consultas.")
    }

    System_Ext(iotDevice, "Dispositivos IoT", "Sensores externos")
    System_Ext(emailService, "Serviço de Email", "SMTP externo")

    Rel(paciente, webApp, "Interage", "HTTPS")
    Rel(medico, webApp, "Interage", "HTTPS")
    Rel(webApp, apiApp, "Faz chamadas API (Fetch/Axios)", "JSON/HTTPS")
    Rel(apiApp, database, "Persistência (Spring Data JPA/Hibernate)", "JDBC/TCP")
    Rel(iotDevice, apiApp, "Envia dados vitais", "MQTT/REST")
    Rel(apiApp, emailService, "Envia notificações", "SMTP")
```

## Descrição dos Contêineres

| Contêiner          | Tecnologia              | Responsabilidade                                                       |
| ------------------ | ----------------------- | ---------------------------------------------------------------------- |
| **SPA (Frontend)** | React.js + TypeScript   | Interface responsiva, gerenciamento de estado, chamadas à API REST     |
| **API Backend**    | Java 21 + Spring Boot 3 | Clean Architecture, endpoints REST, regras de domínio, segurança (JWT) |
| **Banco de Dados** | PostgreSQL              | Persistência de dados relacionais com integridade referencial          |

## Fluxos de Dados

1. **Usuário → SPA**: Interação via navegador (HTTPS)
2. **SPA → API**: Chamadas REST com JSON (Axios/Fetch)
3. **API → BD**: Persistência via Spring Data JPA (JDBC)
4. **IoT → API**: Telemetria via MQTT ou REST endpoints
5. **API → Email**: Disparo de notificações via SMTP

## Tecnologias e Justificativas

| Escolha                | Justificativa                                                             |
| ---------------------- | ------------------------------------------------------------------------- |
| **React + TypeScript** | SPA moderna com tipagem estática para maior confiabilidade                |
| **Spring Boot 3**      | Framework robusto com suporte nativo a Clean Architecture                 |
| **PostgreSQL**         | SGBD relacional open-source com excelente performance e conformidade ACID |
