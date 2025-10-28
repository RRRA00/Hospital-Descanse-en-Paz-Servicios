package com.cibertec.mcc_security_service.client.dto;


import lombok.Builder;

@Builder
public record RoleResponse(
        Long id,
        String name
) {
}
