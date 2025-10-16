package com.example.mcc_divice_service.util;

import com.example.mcc_divice_service.dto.VitalSignRequest;
import com.example.mcc_divice_service.dto.VitalSignResponse;
import com.example.mcc_divice_service.model.VitalSign;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {DeviceMapper.class})
public interface VitalSignMapper {
    @Mapping(source = "deviceId",target = "device.id")
    VitalSign toEntity (VitalSignRequest vitalSignRequest);
    VitalSignResponse toDto (VitalSign vitalSign);
    List<VitalSignResponse> toDtoList(List<VitalSign> vitalSigns);
}
