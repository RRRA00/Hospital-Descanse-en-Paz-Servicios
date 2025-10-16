package com.example.mcc_alert_service.service;

import com.example.mcc_alert_service.dto.AlertActionRequest;
import com.example.mcc_alert_service.dto.AlertActionResponse;

import java.util.List;


public interface AlertActionService {
    List<AlertActionResponse> getAllAlertActions();
    AlertActionResponse getAlertActionById(Long id);
    AlertActionResponse createAlertAction(AlertActionRequest alertActionRequest);
    AlertActionResponse updateAlertAction(Long id, AlertActionRequest alertActionRequest);
    void deleteAlertAction(Long id);
}
