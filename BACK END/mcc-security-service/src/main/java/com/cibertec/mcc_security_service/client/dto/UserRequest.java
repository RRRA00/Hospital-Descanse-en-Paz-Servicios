package com.cibertec.mcc_security_service.client.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.Set;

@Builder
public record UserRequest(
        @NotBlank(message = "username no puede estar vacío")
        String username,

        @NotBlank(message = "password no puede estar vacío")
        String password,


        @NotBlank(message = "email no puede estar vacío")
        @Email(message = "el email debe tener un formato válido")
        String email,

        @NotNull(message = "roles no puede ser null")
        Set<Long> roleIds
) {
}

