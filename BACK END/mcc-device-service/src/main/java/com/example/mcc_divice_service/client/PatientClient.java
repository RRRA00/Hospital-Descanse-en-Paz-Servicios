package com.example.mcc_divice_service.client;

import com.example.mcc_divice_service.client.configuration.FeignConfig;
import com.example.mcc_divice_service.client.dto.PatientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "mcc-patient-service", configuration = FeignConfig.class,path = "/patients")
public interface PatientClient {
    @GetMapping("/{id}")
    PatientResponse getPatientById(@PathVariable Long id);
}
