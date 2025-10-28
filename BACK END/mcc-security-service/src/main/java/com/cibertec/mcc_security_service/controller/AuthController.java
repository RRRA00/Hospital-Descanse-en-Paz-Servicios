package com.cibertec.mcc_security_service.controller;

import com.cibertec.mcc_security_service.client.dto.UserRequest;
import com.cibertec.mcc_security_service.dto.AuthRequest;
import com.cibertec.mcc_security_service.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid UserRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }
}

