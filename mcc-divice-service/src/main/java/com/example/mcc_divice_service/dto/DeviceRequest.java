package com.example.mcc_divice_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record DeviceRequest(
        @NotBlank(message = "serialNumber no puede ser vacio")
        String serialNumber,
        @NotBlank(message = "type no puede ser vacio")
        String type,
        @NotNull(message = "status no puede ser nulo")
        Boolean status,
        @NotNull(message = "serialNumber no puede ser nulo")
        Long assignedPatientId,
        @NotBlank(message = "message no puede ser vacio")
        String location
) {
}
