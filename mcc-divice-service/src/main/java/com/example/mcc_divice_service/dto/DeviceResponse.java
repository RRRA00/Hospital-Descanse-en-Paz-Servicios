package com.example.mcc_divice_service.dto;


import lombok.Builder;


import java.time.LocalDateTime;

@Builder
public record DeviceResponse(
        Long id,
        String serialNumber,
        String type,
        Boolean status,
        Long assignedPatientId,
        LocalDateTime lastCheck
) {
}
