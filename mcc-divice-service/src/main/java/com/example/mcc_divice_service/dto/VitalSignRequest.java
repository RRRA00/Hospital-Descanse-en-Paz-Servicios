package com.example.mcc_divice_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record VitalSignRequest(
        @NotNull(message = "deviceId no puede ser nulo")
        Long deviceId,
        @NotNull(message = "patientId no puede ser nulo")
        Long patientId,
        @NotNull(message = "temperature no puede ser nulo")
        BigDecimal temperature,
        @NotNull(message = "heartRate no puede ser nulo")
        Long heartRate,
        @NotNull(message = "oxygenLevel no puede ser nulo")
        BigDecimal oxygenLevel,
        @NotBlank(message = "bloodPressure no puede ser vacio")
        String bloodPressure
) {
}
