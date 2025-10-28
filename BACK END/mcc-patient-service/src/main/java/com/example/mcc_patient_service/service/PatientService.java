package com.example.mcc_patient_service.service;

import com.example.mcc_patient_service.dto.PatientRequest;
import com.example.mcc_patient_service.dto.PatientResponse;

import java.util.List;

public interface PatientService {
    List<PatientResponse> getAllPatient();
    PatientResponse getPatientById(Long id);
    PatientResponse createPatient(PatientRequest patientRequest);
    PatientResponse updatePatient(Long id, PatientRequest patientRequest);
    void deletePatient(Long id);
}
