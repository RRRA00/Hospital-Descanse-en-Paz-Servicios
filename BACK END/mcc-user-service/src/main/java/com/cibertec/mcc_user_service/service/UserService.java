package com.cibertec.mcc_user_service.service;

import com.cibertec.mcc_user_service.dto.UserRequest;
import com.cibertec.mcc_user_service.dto.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAllUsers();
    UserResponse getUserById(Long id);
    UserResponse createUser(UserRequest request);
    UserResponse updateUser(Long id, UserRequest request);
    void deleteUser(Long id);

    UserResponse getUserByEmail(String email);
}

