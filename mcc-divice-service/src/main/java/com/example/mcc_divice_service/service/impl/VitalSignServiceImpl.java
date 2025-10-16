package com.example.mcc_divice_service.service.impl;

import com.example.mcc_divice_service.dto.VitalSignRequest;
import com.example.mcc_divice_service.dto.VitalSignResponse;
import com.example.mcc_divice_service.exeption.ResourceNotFound;
import com.example.mcc_divice_service.model.VitalSign;
import com.example.mcc_divice_service.repository.VitalSignRepository;
import com.example.mcc_divice_service.service.VitalSignService;
import com.example.mcc_divice_service.util.VitalSignMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VitalSignServiceImpl implements VitalSignService {
    private final VitalSignMapper vitalSignMapper;
    private final VitalSignRepository vitalSignRepository;

    @Override
    public List<VitalSignResponse> getAllVitalSign() {
        return vitalSignMapper.toDtoList(vitalSignRepository.findAll());
    }

    @Override
    public VitalSignResponse getVitalSignById(Long id) {
        return vitalSignMapper.toDto(vitalSignRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("alert action not found with id: " + id)
        ));
    }

    @Override
    public VitalSignResponse createVitalSign(VitalSignRequest vitalSignRequest) {
        return vitalSignMapper.toDto(vitalSignRepository.save(vitalSignMapper.toEntity(vitalSignRequest)));
    }

    @Override
    public VitalSignResponse updateVitalSign(Long id, VitalSignRequest vitalSignRequest) {
        VitalSign vitalSignFound = vitalSignRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("vital Sign action not found with id: " + id)
        );
        vitalSignFound.setDevice(vitalSignMapper.toEntity(vitalSignRequest).getDevice());
        vitalSignFound.setPatientId(vitalSignRequest.patientId());
        vitalSignFound.setTemperature(vitalSignRequest.temperature());
        vitalSignFound.setHeartRate(vitalSignRequest.heartRate());
        vitalSignFound.setOxygenLevel(vitalSignRequest.oxygenLevel());
        vitalSignFound.setBloodPressure(vitalSignRequest.bloodPressure());
        return null;
    }

    @Override
    public void deleteVitalSign(Long id) {
        VitalSign vitalSignFound = vitalSignRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("vital Sign action not found with id: " + id)
        );
        vitalSignRepository.delete(vitalSignFound);
    }
}
