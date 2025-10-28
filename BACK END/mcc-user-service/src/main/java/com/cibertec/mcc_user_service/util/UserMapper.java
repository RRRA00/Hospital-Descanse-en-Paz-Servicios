package com.cibertec.mcc_user_service.util;


import com.cibertec.mcc_user_service.dto.UserRequest;
import com.cibertec.mcc_user_service.dto.UserResponse;
import com.cibertec.mcc_user_service.model.Role;
import com.cibertec.mcc_user_service.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UserMapper {

    @Mapping(source = "roleIds", target = "roles")
    User toEntity(UserRequest request);

    UserResponse toDto(User user);

    List<UserResponse> toDtoList(List<User> users);

    /**
     * MapStruct llamará este método automáticamente para convertir roleIds -> Set<Role>.
     * Se usa para asignar roles sin cargar la BD (referencias).
     */
    default Set<Role> mapRoleIdsToRoles(Set<Long> roleIds) {
        if (roleIds == null) return null;
        return roleIds.stream()
                .map(id -> Role.builder().id(id).build()) // solo referencia
                .collect(Collectors.toSet());
    }
}

