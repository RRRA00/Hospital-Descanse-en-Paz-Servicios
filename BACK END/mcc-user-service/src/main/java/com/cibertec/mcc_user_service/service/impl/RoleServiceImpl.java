package com.cibertec.mcc_user_service.service.impl;


import com.cibertec.mcc_user_service.dto.RoleRequest;
import com.cibertec.mcc_user_service.dto.RoleResponse;
import com.cibertec.mcc_user_service.exception.ResourceNotFound;
import com.cibertec.mcc_user_service.model.Role;
import com.cibertec.mcc_user_service.repository.RolRepository;
import com.cibertec.mcc_user_service.service.RoleService;
import com.cibertec.mcc_user_service.util.RoleMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RolRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public List<RoleResponse> getAllRoles() {
        return roleMapper.toDtoList(roleRepository.findAll());
    }

    @Override
    public RoleResponse getRoleById(Long id) {
        return roleMapper.toDto(roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Role not found with id: " + id)));
    }

    @Override
    public RoleResponse createRole(RoleRequest request) {
        Role role = roleMapper.toEntity(request);
        return roleMapper.toDto(roleRepository.save(role));
    }

    @Override
    public RoleResponse updateRole(Long id, RoleRequest request) {
        Role roleFound = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Role not found with id: " + id));

        roleFound.setName(request.name());
        return roleMapper.toDto(roleRepository.save(roleFound));
    }

    @Override
    public void deleteRole(Long id) {
        Role roleFound = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Role not found with id: " + id));
        roleRepository.delete(roleFound);
    }
}

