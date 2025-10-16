package com.example.mcc_alert_service.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record AlertResponse(
        Long id,
        Long patientId,
        Long deviceId,
        String type,
        String message,
        String level,
        Boolean acknowledged,
        LocalDateTime createdAt
) {
}
