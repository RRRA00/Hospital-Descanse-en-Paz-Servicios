package com.cibertec.mcc_user_service.util;


import com.cibertec.mcc_user_service.dto.RoleRequest;
import com.cibertec.mcc_user_service.dto.RoleResponse;
import com.cibertec.mcc_user_service.model.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role toEntity(RoleRequest request);

    RoleResponse toDto(Role role);

    List<RoleResponse> toDtoList(List<Role> roles);
}
