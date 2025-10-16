package com.example.mcc_alert_service.dto;


import lombok.Builder;

@Builder
public record AlertActionResponse(
        Long id,
        AlertResponse alert,
        String action,
        String performedBy,
        String performedAt
) {
}
