package com.example.mcc_alert_service.repository;

import com.example.mcc_alert_service.model.AlertAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertActionRepository extends JpaRepository<AlertAction, Long> {
}
