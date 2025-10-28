package com.cibertec.mcc_user_service.repository;

import com.cibertec.mcc_user_service.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Role, Long> {
}
