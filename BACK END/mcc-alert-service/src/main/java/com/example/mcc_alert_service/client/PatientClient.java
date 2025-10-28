package com.example.mcc_alert_service.client;

import com.example.mcc_alert_service.client.configuration.FeignConfig;
import com.example.mcc_alert_service.client.dto.PatientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "mcc-patient-service", configuration = FeignConfig.class , path = "/patient")
public interface PatientClient {
    @GetMapping("/{id}")
    PatientResponse getPatientById(Long id);
}
