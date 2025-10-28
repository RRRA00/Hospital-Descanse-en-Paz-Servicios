package com.cibertec.mcc_security_service.service;


import com.cibertec.mcc_security_service.client.dto.UserRequest;
import com.cibertec.mcc_security_service.client.dto.UserResponse;
import com.cibertec.mcc_security_service.dto.AuthRequest;
import com.cibertec.mcc_security_service.dto.AuthResponse;

public interface AuthService {

    AuthResponse login(AuthRequest authRequest);

    UserResponse register(UserRequest userRequest);
}

