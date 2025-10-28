DROP DATABASE IF EXISTS hospital_alert_service;
CREATE DATABASE IF NOT EXISTS hospital_alert_service;
USE hospital_alert_service;

-- Tabla de alertas generadas
CREATE TABLE IF NOT EXISTS alerts (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  patient_id BIGINT NOT NULL,         -- ID proveniente del patient-service
  device_id BIGINT NOT NULL,          -- ID proveniente del device-service
  type VARCHAR(100) NOT NULL,         -- Ejemplo: "ALTA FRECUENCIA CARDIACA"
  message VARCHAR(255) NOT NULL,
  level VARCHAR(20) NOT NULL,         -- "CRITICAL", "WARNING", "INFO"
  acknowledged BOOLEAN DEFAULT FALSE,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Historial de acciones sobre alertas
CREATE TABLE IF NOT EXISTS alert_actions (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  alert_id BIGINT NOT NULL,
  action VARCHAR(100) NOT NULL,       -- Ejemplo: "NOTIFICAR MÉDICO", "ENVIAR SMS"
  performed_by VARCHAR(100),
  performed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (alert_id) REFERENCES alerts(id)
);
-- Insertar 5 alertas
INSERT INTO alerts (patient_id, device_id, type, message, level, acknowledged)
VALUES
(1, 101, 'ALTA FRECUENCIA CARDIACA', 'El paciente presenta una frecuencia cardíaca de 130 bpm.', 'CRITICAL', FALSE),
(2, 102, 'BAJO NIVEL DE OXIGENO', 'El paciente tiene un nivel de oxígeno de 88%.', 'CRITICAL', FALSE),
(3, 103, 'TEMPERATURA ELEVADA', 'El paciente registra una temperatura de 39.2°C.', 'WARNING', FALSE),
(4, 104, 'FALLA DE SENSOR', 'El dispositivo dejó de enviar datos durante 10 minutos.', 'INFO', TRUE),
(5, 105, 'PRESIÓN ALTA', 'El paciente tiene una presión arterial de 150/100 mmHg.', 'WARNING', FALSE);

-- Insertar acciones para cada alerta
INSERT INTO alert_actions (alert_id, action, performed_by)
VALUES
(1, 'NOTIFICAR MÉDICO', 'Dr. Pérez'),
(1, 'ENVIAR SMS A ENFERMERÍA', 'Sistema Automático'),
(2, 'ACTIVAR ALERTA EN MONITOR', 'Sistema Automático'),
(3, 'REGISTRAR EN HISTORIAL', 'Enfermera López'),
(4, 'REINICIAR DISPOSITIVO', 'Técnico Ramírez'),
(5, 'NOTIFICAR FAMILIAR', 'Sistema Automático');