package com.example.mcc_divice_service.service;

import com.example.mcc_divice_service.dto.VitalSignRequest;
import com.example.mcc_divice_service.dto.VitalSignResponse;

import java.util.List;

public interface VitalSignService {
    List<VitalSignResponse> getAllVitalSign();
    VitalSignResponse getVitalSignById(Long id);
    VitalSignResponse createVitalSign(VitalSignRequest vitalSignRequest);
    VitalSignResponse updateVitalSign(Long id, VitalSignRequest vitalSignRequest);
    void deleteVitalSign(Long id);

}
