package com.example.mcc_alert_service.client;


import com.example.mcc_alert_service.client.configuration.FeignConfig;
import com.example.mcc_alert_service.client.dto.DeviceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "mcc-device-service", configuration = FeignConfig.class , path = "/device")
public interface DeviceClient {
    @GetMapping("/{id}")
    DeviceResponse getDeviceById(Long id);
}
