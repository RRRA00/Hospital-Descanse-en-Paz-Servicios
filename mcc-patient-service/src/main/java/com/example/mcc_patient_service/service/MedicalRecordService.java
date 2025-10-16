package com.example.mcc_patient_service.service;

import com.example.mcc_patient_service.dto.MedicalRecordRequest;
import com.example.mcc_patient_service.dto.MedicalRecordResponse;

import java.util.List;

public interface MedicalRecordService {
    List<MedicalRecordResponse> getAllMedicalRecord();
    MedicalRecordResponse getMedicalRecordById(Long id);
    MedicalRecordResponse createMedicalRecord(MedicalRecordRequest medicalRecordRequest);
    MedicalRecordResponse updateMedicalRecord(Long id, MedicalRecordRequest medicalRecordRequest);
    void deleteMedicalRecord(Long id);
}
