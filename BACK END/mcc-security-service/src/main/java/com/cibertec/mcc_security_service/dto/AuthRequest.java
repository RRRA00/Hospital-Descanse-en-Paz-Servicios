package com.cibertec.mcc_security_service.dto;


import lombok.Builder;


@Builder
public record AuthRequest(
        String email,
        String password
) {}


