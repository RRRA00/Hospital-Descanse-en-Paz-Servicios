package com.example.mcc_alert_service.util;

import com.example.mcc_alert_service.dto.AlertRequest;
import com.example.mcc_alert_service.dto.AlertResponse;
import com.example.mcc_alert_service.model.Alert;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AlertMapper {
    Alert toEntity(AlertRequest alertRequest);
    AlertResponse toDto(Alert alert);
    List<AlertResponse> toDtoList(List<Alert> alerts);
}
