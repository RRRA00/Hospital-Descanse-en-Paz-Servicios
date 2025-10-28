package com.example.mcc_alert_service.client.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record VitalSignResponse(
        Long id,
        DeviceResponse deviceId,
        Long patientId,
        BigDecimal temperature,
        Long heartRate,
        BigDecimal oxygenLevel,
        String bloodPressure,
        LocalDateTime measurementTime
) {
}
