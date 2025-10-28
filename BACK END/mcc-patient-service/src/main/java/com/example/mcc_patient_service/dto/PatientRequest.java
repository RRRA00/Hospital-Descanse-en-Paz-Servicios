package com.example.mcc_patient_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record PatientRequest(
        @NotBlank(message = "documentNumber no puede estar vacio")
        String documentNumber,
        @NotBlank(message = "firstName no puede estar vacio")
        String firstName,
        @NotBlank(message = "lastName no puede estar vacio")
        String lastName,
        @NotNull(message = "birthDate no puede estar null")
        LocalDate birthDate,
        @NotBlank(message = "gender no puede estar vacio")
        String gender,
        @NotBlank(message = "email no puede estar vacio")
        String email,
        @NotBlank(message = "phone no puede estar vacio")
        String phone,
        @NotNull(message = "active no puede estar null")
        Boolean active
) {
}
