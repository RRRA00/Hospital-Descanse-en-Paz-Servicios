DROP DATABASE IF EXISTS hospital_user_service;
CREATE DATABASE IF NOT EXISTS hospital_user_service;
USE hospital_user_service;
-- =======================================================
-- 1) TABLA DE USUARIOS
-- =======================================================
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(150) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    enabled BOOLEAN NOT NULL DEFAULT TRUE
);

-- =======================================================
-- 2) TABLA DE ROLES
-- =======================================================
CREATE TABLE roles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);

-- =======================================================
-- 3) TABLA INTERMEDIA (RELACIÓN MANY-TO-MANY)
-- =======================================================
CREATE TABLE user_roles (
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE
);
INSERT INTO roles (name) VALUES
('ADMIN'),
('DOCTOR'),
('ENFERMERA'),
('RECEPCIONISTA'),
('PACIENTE');

