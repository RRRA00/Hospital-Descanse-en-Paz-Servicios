package com.example.mcc_alert_service.util;

import com.example.mcc_alert_service.dto.AlertActionRequest;

import com.example.mcc_alert_service.dto.AlertActionResponse;
import com.example.mcc_alert_service.model.AlertAction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AlertMapper.class})
public interface AlertActionMapper {
    @Mapping(source = "alertId", target = "alert.id" )
    AlertAction toEntity(AlertActionRequest alertActionRequest);
    AlertActionResponse toDto(AlertAction alertAction);
    List<AlertActionResponse> toDtoList(List<AlertAction> alertActions);
}
