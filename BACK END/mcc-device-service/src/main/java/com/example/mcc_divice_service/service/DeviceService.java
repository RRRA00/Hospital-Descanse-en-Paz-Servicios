package com.example.mcc_divice_service.service;

import com.example.mcc_divice_service.dto.DeviceRequest;
import com.example.mcc_divice_service.dto.DeviceResponse;

import java.util.List;

public interface DeviceService {
    List<DeviceResponse> getAllDevice();
    DeviceResponse getDeviceById(Long id);
    DeviceResponse createDevice(DeviceRequest deviceRequest);
    DeviceResponse updateDevice(Long id, DeviceRequest deviceRequest);
    void deleteDevice(Long id);

}
