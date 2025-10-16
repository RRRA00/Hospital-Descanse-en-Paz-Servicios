DROP DATABASE IF EXISTS hospital_patient_service;
CREATE DATABASE IF NOT EXISTS hospital_patient_service;
USE hospital_patient_service;

-- Tabla de pacientes
CREATE TABLE IF NOT EXISTS patients (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  document_number VARCHAR(20) NOT NULL UNIQUE,
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  birth_date TIMESTAMP,
  gender VARCHAR(10),
  email VARCHAR(100),
  phone VARCHAR(20),
  active BOOLEAN DEFAULT TRUE,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Historial médico (referencia interna dentro del microservicio)
CREATE TABLE IF NOT EXISTS medical_records (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  patient_id BIGINT NOT NULL,
  description VARCHAR(255),
  diagnosis VARCHAR(255),
  record_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (patient_id) REFERENCES patients(id)
);

USE hospital_patient_service;

-- 🔹 Insertar pacientes
INSERT INTO patients (document_number, first_name, last_name, birth_date, gender, email, phone, active)
VALUES
('DNI1001', 'María', 'Ramírez López', '1985-03-12', 'F', 'maria.ramirez@example.com', '987654321', TRUE),
('DNI1002', 'José', 'García Torres', '1990-07-25', 'M', 'jose.garcia@example.com', '912345678', TRUE),
('DNI1003', 'Lucía', 'Fernández Vega', '1978-11-09', 'F', 'lucia.fernandez@example.com', '998877665', TRUE),
('DNI1004', 'Carlos', 'Mendoza Ruiz', '2001-01-15', 'M', 'carlos.mendoza@example.com', '911223344', TRUE),
('DNI1005', 'Rosa', 'Castro León', '1968-05-03', 'F', 'rosa.castro@example.com', '900112233', FALSE);

-- 🔹 Insertar historial médico
INSERT INTO medical_records (patient_id, description, diagnosis)
VALUES
(1, 'Consulta general anual', 'Sin hallazgos relevantes'),
(1, 'Control de presión arterial', 'Hipertensión leve'),
(2, 'Dolor torácico leve', 'Angina estable'),
(3, 'Control de diabetes', 'Diabetes tipo 2 controlada'),
(4, 'Chequeo deportivo', 'Buen estado general'),
(5, 'Chequeo de rutina', 'Colesterol elevado');



SELECT * FROM patients;
SELECT * FROM medical_records;
