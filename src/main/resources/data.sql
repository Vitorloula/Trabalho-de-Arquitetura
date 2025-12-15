-- =============================================
-- DADOS DE EXEMPLO - HEALTHMONITOR
-- =============================================

-- Pacientes
INSERT INTO tb_pacientes (id, nome, email, cpf, data_nascimento) VALUES ('123e4567-e89b-12d3-a456-426614174001', 'Joao da Silva', 'joao.silva@email.com', '12345678900', '1985-03-15');
INSERT INTO tb_pacientes (id, nome, email, cpf, data_nascimento) VALUES ('123e4567-e89b-12d3-a456-426614174002', 'Maria Santos Oliveira', 'maria.santos@email.com', '98765432100', '1990-07-22');
INSERT INTO tb_pacientes (id, nome, email, cpf, data_nascimento) VALUES ('123e4567-e89b-12d3-a456-426614174003', 'Pedro Henrique Costa', 'pedro.costa@email.com', '45678912300', '1978-11-08');

-- Sinais Vitais - Joao da Silva
INSERT INTO tb_sinais_vitais (id, vital_value, type, unit, patient_id, created_at) VALUES ('a1b2c3d4-e5f6-7890-abcd-ef1234567801', 72.0, 'FREQUENCIA_CARDIACA', 'bpm', '123e4567-e89b-12d3-a456-426614174001', '2024-12-15 08:00:00');
INSERT INTO tb_sinais_vitais (id, vital_value, type, unit, patient_id, created_at) VALUES ('a1b2c3d4-e5f6-7890-abcd-ef1234567802', 120.0, 'PRESSAO_SISTOLICA', 'mmHg', '123e4567-e89b-12d3-a456-426614174001', '2024-12-15 08:00:00');
INSERT INTO tb_sinais_vitais (id, vital_value, type, unit, patient_id, created_at) VALUES ('a1b2c3d4-e5f6-7890-abcd-ef1234567803', 80.0, 'PRESSAO_DIASTOLICA', 'mmHg', '123e4567-e89b-12d3-a456-426614174001', '2024-12-15 08:00:00');
INSERT INTO tb_sinais_vitais (id, vital_value, type, unit, patient_id, created_at) VALUES ('a1b2c3d4-e5f6-7890-abcd-ef1234567804', 36.5, 'TEMPERATURA', 'Celsius', '123e4567-e89b-12d3-a456-426614174001', '2024-12-15 08:00:00');
INSERT INTO tb_sinais_vitais (id, vital_value, type, unit, patient_id, created_at) VALUES ('a1b2c3d4-e5f6-7890-abcd-ef1234567805', 98.0, 'SATURACAO_OXIGENIO', 'porcento', '123e4567-e89b-12d3-a456-426614174001', '2024-12-15 08:00:00');

-- Sinais Vitais - Maria Santos Oliveira
INSERT INTO tb_sinais_vitais (id, vital_value, type, unit, patient_id, created_at) VALUES ('a1b2c3d4-e5f6-7890-abcd-ef1234567806', 85.0, 'FREQUENCIA_CARDIACA', 'bpm', '123e4567-e89b-12d3-a456-426614174002', '2024-12-15 09:00:00');
INSERT INTO tb_sinais_vitais (id, vital_value, type, unit, patient_id, created_at) VALUES ('a1b2c3d4-e5f6-7890-abcd-ef1234567807', 130.0, 'PRESSAO_SISTOLICA', 'mmHg', '123e4567-e89b-12d3-a456-426614174002', '2024-12-15 09:00:00');
INSERT INTO tb_sinais_vitais (id, vital_value, type, unit, patient_id, created_at) VALUES ('a1b2c3d4-e5f6-7890-abcd-ef1234567808', 85.0, 'PRESSAO_DIASTOLICA', 'mmHg', '123e4567-e89b-12d3-a456-426614174002', '2024-12-15 09:00:00');

-- Sinais Vitais - Pedro Henrique Costa
INSERT INTO tb_sinais_vitais (id, vital_value, type, unit, patient_id, created_at) VALUES ('a1b2c3d4-e5f6-7890-abcd-ef1234567809', 68.0, 'FREQUENCIA_CARDIACA', 'bpm', '123e4567-e89b-12d3-a456-426614174003', '2024-12-15 10:00:00');
INSERT INTO tb_sinais_vitais (id, vital_value, type, unit, patient_id, created_at) VALUES ('a1b2c3d4-e5f6-7890-abcd-ef1234567810', 115.0, 'PRESSAO_SISTOLICA', 'mmHg', '123e4567-e89b-12d3-a456-426614174003', '2024-12-15 10:00:00');
INSERT INTO tb_sinais_vitais (id, vital_value, type, unit, patient_id, created_at) VALUES ('a1b2c3d4-e5f6-7890-abcd-ef1234567811', 75.0, 'PRESSAO_DIASTOLICA', 'mmHg', '123e4567-e89b-12d3-a456-426614174003', '2024-12-15 10:00:00');
INSERT INTO tb_sinais_vitais (id, vital_value, type, unit, patient_id, created_at) VALUES ('a1b2c3d4-e5f6-7890-abcd-ef1234567812', 37.2, 'TEMPERATURA', 'Celsius', '123e4567-e89b-12d3-a456-426614174003', '2024-12-15 10:00:00');
