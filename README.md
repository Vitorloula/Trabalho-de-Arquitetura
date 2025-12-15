# 🏥 HealthMonitor

Sistema de Gestão de Saúde e Histórico Clínico desenvolvido com **Clean Architecture**.

---

## 📋 Informações do Projeto

| Item                       | Descrição                                           |
| -------------------------- | --------------------------------------------------- |
| **Modelo de Documentação** | C4 Model (Contexto, Contêiner, Componentes, Código) |
| **Estilo Arquitetural**    | Clean Architecture                                  |
| **Backend**                | Java 21 + Spring Boot 3.2                           |
| **Banco de Dados**         | H2 (desenvolvimento) / PostgreSQL (produção)        |
| **Documentação API**       | Swagger/OpenAPI                                     |

---

## 🏗️ Estrutura do Projeto

```
healthmonitor/
├── backend/
│   └── src/main/java/com/healthmonitor/
│       ├── domain/                    # Camada de Domínio
│       │   └── entities/              # VitalSign, Paciente, Alerta
│       ├── application/               # Camada de Aplicação
│       │   ├── usecases/              # RegisterVitalSignUseCase, GetPatientVitalsUseCase
│       │   └── gateways/              # Interfaces (IVitalSignGateway, IPacienteGateway)
│       ├── infrastructure/            # Camada de Infraestrutura
│       │   ├── controllers/           # VitalSignController
│       │   ├── gateways/              # VitalSignGatewayImpl
│       │   ├── persistence/           # JPA Entities e Repositories
│       │   ├── dtos/                  # Request/Response DTOs
│       │   └── mappers/               # Conversores DTO ↔ Domain ↔ JPA
│       └── config/                    # Configurações Spring
├── C4_Nivel1_Contexto.md
├── C4_Nivel2_Containeres.md
├── C4_Nivel3_Componentes.md
├── C4_Nivel4_*.md                     # Diagramas de código (4 casos de uso)
├── GUIA_PASSO_A_PASSO.md
└── EXEMPLOS_TESTE.md
```

---

## 🚀 Como Executar

### Pré-requisitos

- Java 21+
- Maven 3.8+

### Executar a Aplicação

```bash
cd backend
mvn clean spring-boot:run
```

A aplicação estará disponível em: **http://localhost:8080**

---

## 📡 Endpoints da API

| Método | Endpoint                   | Descrição                     |
| ------ | -------------------------- | ----------------------------- |
| `GET`  | `/api/vitals`              | Listar todos os sinais vitais |
| `POST` | `/api/vitals`              | Registrar novo sinal vital    |
| `GET`  | `/api/vitals/patient/{id}` | Listar sinais de um paciente  |

### Exemplo - Registrar Sinal Vital

```bash
curl -X POST http://localhost:8080/api/vitals \
  -H "Content-Type: application/json" \
  -d '{
    "value": 75.0,
    "type": "FREQUENCIA_CARDIACA",
    "unit": "bpm",
    "patientId": "123e4567-e89b-12d3-a456-426614174001"
  }'
```

---

## � URLs Importantes

| Recurso        | URL                                   |
| -------------- | ------------------------------------- |
| **Swagger UI** | http://localhost:8080/swagger-ui.html |
| **H2 Console** | http://localhost:8080/h2-console      |

### Configuração H2 Console

- **JDBC URL**: `jdbc:h2:mem:healthmonitor`
- **User**: `sa`
- **Password**: _(vazio)_

---

## 🩺 Tipos de Sinais Vitais

| Tipo                  | Descrição                   | Unidade  |
| --------------------- | --------------------------- | -------- |
| `FREQUENCIA_CARDIACA` | Batimentos cardíacos        | bpm      |
| `PRESSAO_SISTOLICA`   | Pressão arterial máxima     | mmHg     |
| `PRESSAO_DIASTOLICA`  | Pressão arterial mínima     | mmHg     |
| `TEMPERATURA`         | Temperatura corporal        | Celsius  |
| `SATURACAO_OXIGENIO`  | Nível de oxigênio no sangue | porcento |

---

## 🏥 Pacientes de Teste

| Nome                  | UUID                                   |
| --------------------- | -------------------------------------- |
| João da Silva         | `123e4567-e89b-12d3-a456-426614174001` |
| Maria Santos Oliveira | `123e4567-e89b-12d3-a456-426614174002` |
| Pedro Henrique Costa  | `123e4567-e89b-12d3-a456-426614174003` |

---

## 📚 Documentação C4

Os diagramas seguem o modelo C4:

1. **Nível 1 - Contexto**: Visão geral do sistema e atores
2. **Nível 2 - Contêineres**: SPA, API Backend, Banco de Dados
3. **Nível 3 - Componentes**: Estrutura interna do Spring Boot
4. **Nível 4 - Código**: Implementação dos casos de uso

---

## 👥 Equipe

| Nome     | Matrícula   |
| -------- | ----------- |
| [Nome 1] | [Matrícula] |
| [Nome 2] | [Matrícula] |

---

## 📄 Licença

Este projeto foi desenvolvido para fins acadêmicos.
