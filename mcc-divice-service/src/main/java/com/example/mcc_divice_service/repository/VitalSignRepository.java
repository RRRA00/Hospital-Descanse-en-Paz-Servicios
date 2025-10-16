package com.example.mcc_divice_service.repository;

import com.example.mcc_divice_service.model.VitalSign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VitalSignRepository extends JpaRepository<VitalSign, Long> {
}
