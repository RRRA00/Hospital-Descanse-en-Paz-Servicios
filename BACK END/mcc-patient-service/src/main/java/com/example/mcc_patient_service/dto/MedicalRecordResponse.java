package com.example.mcc_patient_service.dto;

import com.example.mcc_patient_service.model.Patient;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record MedicalRecordResponse(
        Long id,
        PatientResponse patient,
        String description,
        String diagnosis,
        LocalDateTime recordDate
) {
}
