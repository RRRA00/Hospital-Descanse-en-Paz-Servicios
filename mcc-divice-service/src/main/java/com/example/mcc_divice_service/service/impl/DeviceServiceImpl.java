package com.example.mcc_divice_service.service.impl;

import com.example.mcc_divice_service.dto.DeviceRequest;
import com.example.mcc_divice_service.dto.DeviceResponse;
import com.example.mcc_divice_service.exeption.ResourceNotFound;
import com.example.mcc_divice_service.model.Device;
import com.example.mcc_divice_service.repository.DeviceRepository;
import com.example.mcc_divice_service.service.DeviceService;
import com.example.mcc_divice_service.util.DeviceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository deviceRepository;
    private final DeviceMapper deviceMapper;

    @Override
    public List<DeviceResponse> getAllDevice() {
        return deviceMapper.toDtoList(deviceRepository.findAll());
    }

    @Override
    public DeviceResponse getDeviceById(Long id) {
        return deviceMapper.toDto(deviceRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Device item not found with id: " + id)
        ));
    }

    @Override
    public DeviceResponse createDevice(DeviceRequest deviceRequest) {
        return deviceMapper.toDto(deviceRepository.save(deviceMapper.toEntity(deviceRequest)));
    }

    @Override
    public DeviceResponse updateDevice(Long id, DeviceRequest deviceRequest) {
        Device deviceFound = deviceRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("device action not found with id: " + id)
        );
        deviceFound.setSerialNumber(deviceRequest.serialNumber());
        deviceFound.setType(deviceRequest.type());
        deviceFound.setStatus(deviceRequest.status());
        deviceFound.setAssignedPatientId(deviceRequest.assignedPatientId());
        deviceFound.setLocation(deviceRequest.location());
        return null;
    }

    @Override
    public void deleteDevice(Long id) {
        Device deviceFound = deviceRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("device action not found with id: " + id)
        );
        deviceRepository.delete(deviceFound);

    }
}
