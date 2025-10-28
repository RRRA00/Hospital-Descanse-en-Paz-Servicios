package com.cibertec.mcc_user_service.dto;

import lombok.Builder;

import java.util.Set;

@Builder
public record UserResponse(
        Long id,
        String password,
        String username,
        boolean enabled,
        String email,
        Set<RoleResponse> roles
) {
}
