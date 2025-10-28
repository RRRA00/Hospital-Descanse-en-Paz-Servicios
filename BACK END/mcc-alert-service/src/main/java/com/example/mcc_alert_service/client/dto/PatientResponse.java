package com.example.mcc_alert_service.client.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record PatientResponse(
        Long id,
        String documentNumber,
        String firstName,
        String lastName,
        LocalDate birthDate,
        String gender,
        String email,
        String phone,
        Boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
