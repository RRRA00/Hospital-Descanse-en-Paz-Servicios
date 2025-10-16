package com.example.mcc_alert_service.service.Impl;

import com.example.mcc_alert_service.dto.AlertRequest;
import com.example.mcc_alert_service.dto.AlertResponse;
import com.example.mcc_alert_service.exeption.ResourceNotFound;
import com.example.mcc_alert_service.model.Alert;
import com.example.mcc_alert_service.repository.AlertRepository;
import com.example.mcc_alert_service.service.AlertService;
import com.example.mcc_alert_service.util.AlertMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlertServiceImpl implements AlertService {
    private final AlertMapper alertMapper;
    private final AlertRepository alertRepository;
    @Override
    public List<AlertResponse> getAllAlerts() {
        return alertMapper.toDtoList(alertRepository.findAll());
    }

    @Override
    public AlertResponse getAlertById(Long id) {
        return alertMapper.toDto(alertRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFound("Alert item not fund with id: "+ id)
        ));
    }

    @Override
    public AlertResponse createAlert(AlertRequest alertRequest) {

        return alertMapper.toDto(alertRepository.save(alertMapper.toEntity(alertRequest)));
    }

    @Override
    public AlertResponse updateAlert(Long id, AlertRequest alertRequest) {
        Alert alertFound = alertRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFound("Alert item not fund with id: "+ id)
        );

        alertFound.setType(alertRequest.type());
        alertFound.setMessage(alertRequest.message());
        alertFound.setLevel(alertRequest.level());
        alertFound.setAcknowledged(alertRequest.acknowledged());
        return alertMapper.toDto(alertRepository.save(alertFound));
    }

    @Override
    public void deleteAlert(Long id) {
        Alert alertFound = alertRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFound("Alert item not fund with id: "+ id)
        );
        alertRepository.delete(alertFound);

    }
}
