DROP DATABASE IF EXISTS hospital_service;
-- Crear base de datos principal
CREATE DATABASE IF NOT EXISTS hospital_service;
USE hospital_service;

-- ==========================================================
-- 1️⃣ TABLAS DE PACIENTES Y SUS REGISTROS MÉDICOS
-- ==========================================================
CREATE TABLE IF NOT EXISTS patients (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  document_number VARCHAR(20) NOT NULL UNIQUE,
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  birth_date DATE,
  gender VARCHAR(10),
  email VARCHAR(100),
  phone VARCHAR(20),
  active BOOLEAN DEFAULT TRUE,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS medical_records (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  patient_id BIGINT NOT NULL,
  description VARCHAR(255),
  diagnosis VARCHAR(255),
  record_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (patient_id) REFERENCES patients(id) ON DELETE CASCADE
);

-- ==========================================================
-- 2️⃣ TABLAS DE DISPOSITIVOS Y SIGNOS VITALES
-- ==========================================================
CREATE TABLE IF NOT EXISTS devices (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  serial_number VARCHAR(50) NOT NULL UNIQUE,
  type VARCHAR(50) NOT NULL,             -- Ejemplo: ECG, Termómetro, Oxímetro
  status BOOLEAN DEFAULT TRUE,           -- Activo o fuera de servicio
  assigned_patient_id BIGINT,            -- Paciente asignado
  location VARCHAR(100),
  last_check TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (assigned_patient_id) REFERENCES patients(id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS vital_signs (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  device_id BIGINT NOT NULL,
  patient_id BIGINT NOT NULL,
  temperature DECIMAL(5,2),
  heart_rate INT,
  oxygen_level DECIMAL(5,2),
  blood_pressure VARCHAR(20),
  measurement_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (device_id) REFERENCES devices(id) ON DELETE CASCADE,
  FOREIGN KEY (patient_id) REFERENCES patients(id) ON DELETE CASCADE
);

-- ==========================================================
-- 3️⃣ TABLAS DE ALERTAS Y ACCIONES ASOCIADAS
-- ==========================================================
CREATE TABLE IF NOT EXISTS alerts (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  patient_id BIGINT NOT NULL,
  device_id BIGINT NOT NULL,
  type VARCHAR(100) NOT NULL,             -- Ejemplo: "Alta frecuencia cardíaca"
  message VARCHAR(255) NOT NULL,
  level VARCHAR(20) NOT NULL,             -- "CRITICAL", "WARNING", "INFO"
  acknowledged BOOLEAN DEFAULT FALSE,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (patient_id) REFERENCES patients(id) ON DELETE CASCADE,
  FOREIGN KEY (device_id) REFERENCES devices(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS alert_actions (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  alert_id BIGINT NOT NULL,
  action VARCHAR(100) NOT NULL,           -- Ejemplo: "Notificar médico"
  performed_by VARCHAR(100),
  performed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (alert_id) REFERENCES alerts(id) ON DELETE CASCADE
);

-- ==========================================================
-- 4️⃣ VISTAS ÚTILES (OPCIONAL)
-- ==========================================================
-- Vista para ver todos los signos vitales con información del paciente y dispositivo
CREATE OR REPLACE VIEW vw_vital_signs_detail AS
SELECT 
    v.id AS vital_id,
    p.first_name,
    p.last_name,
    d.serial_number AS device_serial,
    v.temperature,
    v.heart_rate,
    v.oxygen_level,
    v.blood_pressure,
    v.measurement_time
FROM vital_signs v
JOIN patients p ON v.patient_id = p.id
JOIN devices d ON v.device_id = d.id;

-- Vista para ver alertas con información del paciente
CREATE OR REPLACE VIEW vw_alerts_detail AS
SELECT 
    a.id AS alert_id,
    p.first_name,
    p.last_name,
    d.serial_number,
    a.type,
    a.message,
    a.level,
    a.acknowledged,
    a.created_at
FROM alerts a
JOIN patients p ON a.patient_id = p.id
JOIN devices d ON a.device_id = d.id;

-- ==========================================================
-- 5️⃣ DATOS DE EJEMPLO (opcionales)
-- ==========================================================
INSERT INTO patients (document_number, first_name, last_name, gender, email, phone)
VALUES 
('12345678', 'Ana', 'Torres', 'F', 'ana.torres@example.com', '987654321'),
('87654321', 'Luis', 'Gomez', 'M', 'luis.gomez@example.com', '912345678');

INSERT INTO devices (serial_number, type, status, assigned_patient_id, location)
VALUES 
('DEV-001', 'ECG', TRUE, 1, 'Sala UCI 1'),
('DEV-002', 'Oxímetro', TRUE, 2, 'Sala Emergencia 3');

INSERT INTO vital_signs (device_id, patient_id, temperature, heart_rate, oxygen_level, blood_pressure)
VALUES 
(1, 1, 37.8, 95, 98.5, '120/80'),
(2, 2, 38.5, 120, 91.0, '135/85');

INSERT INTO alerts (patient_id, device_id, type, message, level)
VALUES 
(2, 2, 'TAQUICARDIA', 'Frecuencia cardíaca por encima de lo normal', 'CRITICAL');

INSERT INTO alert_actions (alert_id, action, performed_by)
VALUES 
(1, 'Notificar al cardiólogo', 'Sistema Automático');
