package com.example.mcc_patient_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record MedicalRecordRequest(
        @NotNull(message = "patientId no puede estar null")
        Long patientId,
        @NotBlank(message = "description no puede estar vacio")
        String description,
        @NotBlank(message = "diagnosis no puede estar vacio")
        String diagnosis
) {
}
