# Exemplos de Teste - HealthMonitor API

## IDs dos Pacientes

| Nome                  | UUID                                   |
| --------------------- | -------------------------------------- |
| João da Silva         | `123e4567-e89b-12d3-a456-426614174001` |
| Maria Santos Oliveira | `123e4567-e89b-12d3-a456-426614174002` |
| Pedro Henrique Costa  | `123e4567-e89b-12d3-a456-426614174003` |

---

## Exemplos de JSON para POST /api/vitals

### Frequência Cardíaca

```json
{
  "value": 75.0,
  "type": "FREQUENCIA_CARDIACA",
  "unit": "bpm",
  "patientId": "123e4567-e89b-12d3-a456-426614174001"
}
```

### Pressão Arterial Sistólica

```json
{
  "value": 125.0,
  "type": "PRESSAO_SISTOLICA",
  "unit": "mmHg",
  "patientId": "123e4567-e89b-12d3-a456-426614174002"
}
```

### Pressão Arterial Diastólica

```json
{
  "value": 82.0,
  "type": "PRESSAO_DIASTOLICA",
  "unit": "mmHg",
  "patientId": "123e4567-e89b-12d3-a456-426614174002"
}
```

### Temperatura

```json
{
  "value": 36.8,
  "type": "TEMPERATURA",
  "unit": "Celsius",
  "patientId": "123e4567-e89b-12d3-a456-426614174003"
}
```

### Saturação de Oxigênio

```json
{
  "value": 97.0,
  "type": "SATURACAO_OXIGENIO",
  "unit": "porcento",
  "patientId": "123e4567-e89b-12d3-a456-426614174001"
}
```

---

## Exemplos de cURL

### Listar todos os sinais vitais

```bash
curl -X GET http://localhost:8080/api/vitals
```

### Criar novo sinal vital

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

### Buscar sinais de João da Silva

```bash
curl -X GET http://localhost:8080/api/vitals/patient/123e4567-e89b-12d3-a456-426614174001
```

### Buscar sinais de Maria Santos

```bash
curl -X GET http://localhost:8080/api/vitals/patient/123e4567-e89b-12d3-a456-426614174002
```

### Buscar sinais de Pedro Costa

```bash
curl -X GET http://localhost:8080/api/vitals/patient/123e4567-e89b-12d3-a456-426614174003
```

---

## Tipos de Sinais Vitais Disponíveis

| Tipo                  | Descrição                   | Unidade  |
| --------------------- | --------------------------- | -------- |
| `FREQUENCIA_CARDIACA` | Batimentos cardíacos        | bpm      |
| `PRESSAO_SISTOLICA`   | Pressão arterial máxima     | mmHg     |
| `PRESSAO_DIASTOLICA`  | Pressão arterial mínima     | mmHg     |
| `TEMPERATURA`         | Temperatura corporal        | Celsius  |
| `SATURACAO_OXIGENIO`  | Nível de oxigênio no sangue | porcento |

---

## URLs Importantes

- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **H2 Console**: http://localhost:8080/h2-console
  - JDBC URL: `jdbc:h2:mem:healthmonitor`
  - User: `sa`
  - Password: _(vazio)_
