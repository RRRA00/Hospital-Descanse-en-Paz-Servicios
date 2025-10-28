package com.cibertec.mcc_user_service.service;


import com.cibertec.mcc_user_service.dto.RoleRequest;
import com.cibertec.mcc_user_service.dto.RoleResponse;

import java.util.List;

public interface RoleService {
    List<RoleResponse> getAllRoles();
    RoleResponse getRoleById(Long id);
    RoleResponse createRole(RoleRequest request);
    RoleResponse updateRole(Long id, RoleRequest request);
    void deleteRole(Long id);
}
