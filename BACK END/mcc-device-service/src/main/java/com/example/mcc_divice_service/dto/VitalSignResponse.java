package com.example.mcc_divice_service.dto;

import com.example.mcc_divice_service.model.Device;
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
