package com.example.mcc_alert_service.service;

import com.example.mcc_alert_service.dto.AlertRequest;
import com.example.mcc_alert_service.dto.AlertResponse;
import com.example.mcc_alert_service.dto.VitalSignDTO;

import java.util.List;

public interface AlertService {
    List<AlertResponse> getAllAlerts();
    AlertResponse getAlertById(Long id);
    AlertResponse createAlert(AlertRequest alertRequest);
    AlertResponse updateAlert(Long id, AlertRequest alertRequest);
    void deleteAlert(Long id);
    void processVitalSign(VitalSignDTO vital);
}
