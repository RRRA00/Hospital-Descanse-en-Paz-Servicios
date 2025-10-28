package com.example.mcc_alert_service.service.Impl;

import com.example.mcc_alert_service.dto.AlertActionRequest;
import com.example.mcc_alert_service.dto.AlertActionResponse;
import com.example.mcc_alert_service.exeption.ResourceNotFound;
import com.example.mcc_alert_service.model.AlertAction;
import com.example.mcc_alert_service.repository.AlertActionRepository;
import com.example.mcc_alert_service.service.AlertActionService;
import com.example.mcc_alert_service.util.AlertActionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlertActionServiceImpl implements AlertActionService {
    private final AlertActionMapper alertActionMapper;
    private final AlertActionRepository alertActionRepository;
    @Override
    public List<AlertActionResponse> getAllAlertActions() {
        return alertActionMapper.toDtoList(alertActionRepository.findAll());
    }

    @Override
    public AlertActionResponse getAlertActionById(Long id) {
        return alertActionMapper.toDto(alertActionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("alert action not found with id: " + id)
        ));
    }

    @Override
    public AlertActionResponse createAlertAction(AlertActionRequest alertActionRequest) {
        return alertActionMapper.toDto(alertActionRepository.save(alertActionMapper.toEntity(alertActionRequest)));
    }

    @Override
    public AlertActionResponse updateAlertAction(Long id, AlertActionRequest alertActionRequest) {
        AlertAction alertActionFound = alertActionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("alert action not found with id: " + id)
        );
        alertActionFound.setAlert(alertActionMapper.toEntity(alertActionRequest).getAlert());
        alertActionFound.setAction(alertActionRequest.action());
        alertActionFound.setPerformedBy(alertActionRequest.performedBy());
        return alertActionMapper.toDto(alertActionRepository.save(alertActionFound));
    }

    @Override
    public void deleteAlertAction(Long id) {
        AlertAction alertActionFound = alertActionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("alert action not found with id: " + id)
        );
        alertActionRepository.delete(alertActionFound);
    }
}
