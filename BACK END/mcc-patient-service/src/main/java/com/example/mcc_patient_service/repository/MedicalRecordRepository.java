package com.example.mcc_patient_service.repository;

import com.example.mcc_patient_service.model.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
}
