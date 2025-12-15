# C4 - Nível 3: Diagrama de Componentes

## Componentes do Spring Boot (Clean Architecture)

```mermaid
classDiagram
    title Nível 3: Componentes (Dentro do Spring Boot)
    direction RL

    namespace Infrastructure_Layer {
        class VitalSignController {
            <<Spring RestController>>
            +create(VitalSignRequestDTO)
            +findAll()
        }
        class PostgresVitalSignRepository {
            <<Spring Repository>>
            +save(VitalSignJpaEntity)
            +findById(UUID)
        }
        class VitalSignJpaEntity {
            <<JPA Entity>>
            @Table("tb_sinais")
        }
        class JpaMapper {
            <<Component>>
            +toDomain(JpaEntity) DomainEntity
            +toJpa(DomainEntity) JpaEntity
        }
    }

    namespace Interface_Adapters {
        class VitalSignRepositoryImpl {
            <<Service Adapter>>
            +save(VitalSign domain)
        }
        class VitalSignRequestDTO {
            <<DTO>>
            +Double value
            +String unit
            +String type
        }
        class VitalSignResponseDTO {
            <<DTO>>
            +UUID id
            +Double value
            +String unit
            +LocalDateTime createdAt
        }
        class DTOMapper {
            <<Component>>
            +toDTO(VitalSign) VitalSignResponseDTO
            +toDomain(VitalSignRequestDTO) VitalSign
        }
    }

    namespace Application_Layer {
        class CreateVitalSignUseCase {
            <<Java Class>>
            +execute(VitalSign domain)
        }
        class IVitalSignRepository {
            <<Interface>>
            +save(VitalSign domain)
        }
    }

    namespace Domain_Layer {
        class VitalSign {
            <<POJO>>
            -UUID id
            -Double value
            -String unit
            -String type
            +validate()
            +isCritical() boolean
        }
    }

    VitalSignController ..> CreateVitalSignUseCase : Usa
    VitalSignController ..> DTOMapper : Converte
    VitalSignController ..> VitalSignRequestDTO : Recebe
    VitalSignController ..> VitalSignResponseDTO : Retorna

    CreateVitalSignUseCase ..> VitalSign : Manipula
    CreateVitalSignUseCase ..> IVitalSignRepository : Depende

    VitalSignRepositoryImpl ..|> IVitalSignRepository : Implementa
    VitalSignRepositoryImpl ..> PostgresVitalSignRepository : Usa
    VitalSignRepositoryImpl ..> JpaMapper : Usa

    DTOMapper ..> VitalSign : Converte
```

## Camadas da Clean Architecture

| Camada                   | Componentes                                      | Responsabilidade                                                         |
| ------------------------ | ------------------------------------------------ | ------------------------------------------------------------------------ |
| **Domain Layer**         | `VitalSign`                                      | Entidades de domínio, regras de negócio puras, sem dependências externas |
| **Application Layer**    | `CreateVitalSignUseCase`, `IVitalSignRepository` | Casos de uso, orquestração de fluxos, interfaces de abstração            |
| **Interface Adapters**   | `VitalSignRepositoryImpl`, DTOs, `DTOMapper`     | Adaptadores, conversão entre domínio e infraestrutura                    |
| **Infrastructure Layer** | Controllers, JPA Repositories, Entities, Mappers | Frameworks, drivers, detalhes de implementação                           |

## Fluxo de Dados (Request → Response)

```mermaid
sequenceDiagram
    participant Client
    participant Controller
    participant DTOMapper
    participant UseCase
    participant Repository
    participant JpaMapper
    participant Database

    Client->>Controller: POST /vitals (VitalSignRequestDTO)
    Controller->>DTOMapper: toDomain(requestDTO)
    DTOMapper->>Controller: VitalSign (domain)
    Controller->>UseCase: execute(vitalSign)
    UseCase->>Repository: save(vitalSign)
    Repository->>JpaMapper: toJpa(vitalSign)
    JpaMapper->>Repository: VitalSignJpaEntity
    Repository->>Database: INSERT
    Database->>Repository: OK
    Repository->>JpaMapper: toDomain(jpaEntity)
    JpaMapper->>Repository: VitalSign
    Repository->>UseCase: VitalSign
    UseCase->>Controller: VitalSign
    Controller->>DTOMapper: toDTO(vitalSign)
    DTOMapper->>Controller: VitalSignResponseDTO
    Controller->>Client: 201 Created (ResponseDTO)
```

## Decisões Arquiteturais

1. **DTOs na Interface Adapters**: Separação clara entre representação externa (API) e domínio interno
2. **Dois tipos de Mapper**:
   - `DTOMapper`: Converte entre API ↔ Domain
   - `JpaMapper`: Converte entre Domain ↔ Persistência
3. **Interfaces no Application Layer**: Inversão de dependência para desacoplar implementações
