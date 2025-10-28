package com.cibertec.mcc_user_service.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.Set;

@Builder
public record UserRequest(
        @NotBlank(message = "username no puede estar vacío")
        String username,

        @NotBlank(message = "password no puede estar vacío")
        String password,

        @Email(message = "email debe tener un formato valido")
        @NotBlank(message = "email no puede estar vacio")
        String email,

        @NotNull(message = "roles no puede ser null")
        Set<Long> roleIds
) {
}

