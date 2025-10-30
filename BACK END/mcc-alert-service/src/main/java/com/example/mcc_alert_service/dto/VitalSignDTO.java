package com.example.mcc_alert_service.dto;

import lombok.Builder;

@Builder
public record VitalSignDTO(
        Long patientId,
        Long deviceId,
        Double heartRate,
        Double oxygenLevel,
        String timestamp
) {}
