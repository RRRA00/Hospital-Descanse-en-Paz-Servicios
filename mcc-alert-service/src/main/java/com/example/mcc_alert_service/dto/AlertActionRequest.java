package com.example.mcc_alert_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record AlertActionRequest(
        @NotNull(message = "alertId no puede ser nulo")
        Long alertId,
        @NotBlank(message = "action no puede estar vacio")
        String action,
        @NotBlank(message = "performedBy no puede estar vacio")
        String performedBy
) {
}
