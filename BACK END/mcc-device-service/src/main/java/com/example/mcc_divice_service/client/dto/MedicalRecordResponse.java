package com.example.mcc_divice_service.client.dto;

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
