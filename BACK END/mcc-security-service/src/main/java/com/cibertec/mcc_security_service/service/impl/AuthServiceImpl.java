package com.cibertec.mcc_security_service.service.impl;


import com.cibertec.mcc_security_service.client.UserClient;
import com.cibertec.mcc_security_service.client.dto.UserRequest;
import com.cibertec.mcc_security_service.client.dto.UserResponse;
import com.cibertec.mcc_security_service.dto.AuthRequest;
import com.cibertec.mcc_security_service.dto.AuthResponse;
import com.cibertec.mcc_security_service.exception.BadRequest;
import com.cibertec.mcc_security_service.security.util.JwtUtils;
import com.cibertec.mcc_security_service.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserClient userClient;
    private final JwtUtils jwtUtil;
    private final PasswordEncoder passwordEncoder;


    @Override
    public AuthResponse login(AuthRequest authRequest) {

        System.out.println("Login con email: " + authRequest.email());
        System.out.println("Contraseña ingresada: " + authRequest.password());

        UserResponse user = userClient.getUserByEmail(authRequest.email());

        if (user == null) {
            throw new BadRequest("User not found");
        }

        if (!passwordEncoder.matches(authRequest.password(), user.password())) {
            System.out.println("Contraseña ingresada: " + authRequest.password());
            System.out.println("Hash en BD: " + user.password());
            System.out.println("Coincide: " + passwordEncoder.matches(authRequest.password(), user.password()));
            throw new BadRequest("Invalid email or password");
        }
        String token = jwtUtil.generateAccessToken(user.email());
        return AuthResponse.builder()
                .token(token)
                .username(user.email())
                .build();
    }

    @Override
    public UserResponse register(UserRequest userRequest) {

        if (userRequest.email() == null || userRequest.email().isBlank()) {
            throw new IllegalArgumentException("El email no puede ser nulo ni vacío");
        }

        userRequest = UserRequest.builder()
                .username(userRequest.username())
                .password(userRequest.password())
                .email(userRequest.email())
                .roleIds(userRequest.roleIds())
                .build();

        return userClient.createUser(userRequest);
    }
}
