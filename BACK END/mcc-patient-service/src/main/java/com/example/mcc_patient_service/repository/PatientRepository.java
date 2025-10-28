package com.example.mcc_patient_service.repository;

import com.example.mcc_patient_service.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
