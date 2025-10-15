DROP DATABASE IF EXISTS hospital_device_service;
CREATE DATABASE IF NOT EXISTS hospital_device_service;
USE hospital_device_service;

-- Tabla de dispositivos médicos
CREATE TABLE IF NOT EXISTS devices (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  serial_number VARCHAR(50) NOT NULL UNIQUE,
  type VARCHAR(50) NOT NULL,          -- Ejemplo: ECG, Termómetro, Oxímetro
  status BOOLEAN DEFAULT TRUE,        -- Activo o fuera de servicio
  assigned_patient_id BIGINT,         -- ID del paciente (referencia al microservicio de pacientes)
  location VARCHAR(100),
  last_check TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla de datos de medición (signos vitales)
CREATE TABLE IF NOT EXISTS vital_signs (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  device_id BIGINT NOT NULL,
  patient_id BIGINT NOT NULL,          -- Copiado desde patient-service (no FK real)
  temperature DECIMAL(5,2),
  heart_rate INT,
  oxygen_level DECIMAL(5,2),
  blood_pressure VARCHAR(20),
  measurement_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (device_id) REFERENCES devices(id)
);

-- Dispositivos médicos
INSERT INTO devices (serial_number, type, status, assigned_patient_id, location, last_check)
VALUES
('ECG-1001', 'Electrocardiograma', TRUE, 1, 'Sala de Emergencias', CURRENT_TIMESTAMP),
('TMP-2002', 'Termómetro Digital', TRUE, 2, 'Habitación 203', CURRENT_TIMESTAMP),
('OXI-3003', 'Oxímetro de Pulso', TRUE, 3, 'UCI - Cama 5', CURRENT_TIMESTAMP),
('BP-4004', 'Monitor de Presión', FALSE, 4, 'Habitación 110', CURRENT_TIMESTAMP),
('TMP-5005', 'Termómetro Infrarrojo', TRUE, 5, 'Consultorio 2', CURRENT_TIMESTAMP);

-- Signos vitales (lecturas generadas por los dispositivos)
INSERT INTO vital_signs (device_id, patient_id, temperature, heart_rate, oxygen_level, blood_pressure, measurement_time)
VALUES
(1, 1, 36.80, 78, 98.5, '120/80', CURRENT_TIMESTAMP),
(2, 2, 38.20, 88, 97.0, '118/76', CURRENT_TIMESTAMP),
(3, 3, 37.10, 92, 94.5, '122/84', CURRENT_TIMESTAMP),
(4, 4, 36.50, 70, 99.0, '130/85', CURRENT_TIMESTAMP),
(5, 5, 39.00, 102, 96.0, '115/75', CURRENT_TIMESTAMP);
