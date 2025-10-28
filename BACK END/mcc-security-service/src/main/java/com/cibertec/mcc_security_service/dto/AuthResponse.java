package com.cibertec.mcc_security_service.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record AuthResponse(
        Long userId,
        String username,
        String token,
        List<String> roles

) {

}

