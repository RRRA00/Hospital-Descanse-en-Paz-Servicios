package com.cibertec.mcc_user_service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record RoleRequest(
        @NotBlank(message = "El nombre del rol no puede estar vacío")
        String name
) {
}

