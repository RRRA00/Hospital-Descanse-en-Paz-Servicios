package com.example.mcc_divice_service.util;

import com.example.mcc_divice_service.dto.DeviceRequest;
import com.example.mcc_divice_service.dto.DeviceResponse;
import com.example.mcc_divice_service.model.Device;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DeviceMapper {
    Device toEntity (DeviceRequest deviceRequest);
    DeviceResponse toDto(Device device);
    List<DeviceResponse> toDtoList(List<Device> devices);
}
