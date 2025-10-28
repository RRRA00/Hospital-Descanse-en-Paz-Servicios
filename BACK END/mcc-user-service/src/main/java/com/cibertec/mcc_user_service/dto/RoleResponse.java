package com.cibertec.mcc_user_service.dto;


import lombok.Builder;

@Builder
public record RoleResponse(
        Long id,
        String name
) {
}
