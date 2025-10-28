package com.example.mcc_alert_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record AlertRequest(
        @NotNull(message = "patientId no puede ser nulo")
        Long patientId,
        @NotNull(message = "deviceId no puede ser nulo")
        Long deviceId,
        @NotBlank(message = "type no puede estar vacio")
        String type,
        @NotBlank(message = "message no puede estar vacio")
        String message,
        @NotBlank(message = "level no puede estar vacio")
        String level,
        Boolean acknowledged
) {
}
