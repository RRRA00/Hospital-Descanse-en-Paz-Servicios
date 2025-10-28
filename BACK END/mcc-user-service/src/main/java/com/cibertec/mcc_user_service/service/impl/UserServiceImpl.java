package com.cibertec.mcc_user_service.service.impl;


import com.cibertec.mcc_user_service.dto.UserRequest;
import com.cibertec.mcc_user_service.dto.UserResponse;
import com.cibertec.mcc_user_service.exception.ResourceNotFound;
import com.cibertec.mcc_user_service.model.User;
import com.cibertec.mcc_user_service.repository.UserRepository;
import com.cibertec.mcc_user_service.service.UserService;
import com.cibertec.mcc_user_service.util.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public List<UserResponse> getAllUsers() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    @Override
    public UserResponse getUserById(Long id) {
        return userMapper.toDto(userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("User not found with id: " + id)));
    }

    @Override
    public UserResponse createUser(UserRequest request) {
        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setEnabled(true);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest request) {
        User userFound = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("User not found with id: " + id));

        userFound.setUsername(request.username());
        userFound.setPassword(passwordEncoder.encode(request.password()));
        userFound.setRoles(userMapper.mapRoleIdsToRoles(request.roleIds()));

        return userMapper.toDto(userRepository.save(userFound));
    }

    @Override
    public void deleteUser(Long id) {
        User userFound = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("User not found with id: " + id));
        userRepository.delete(userFound);
    }

    @Override
    public UserResponse getUserByEmail(String email) {
        return userMapper.toDto(userRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFound("User not found with email: " + email)
        ));
    }
}
