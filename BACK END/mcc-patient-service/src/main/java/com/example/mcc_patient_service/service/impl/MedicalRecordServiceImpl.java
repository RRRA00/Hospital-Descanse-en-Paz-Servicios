package com.example.mcc_patient_service.service.impl;

import com.example.mcc_patient_service.dto.MedicalRecordRequest;
import com.example.mcc_patient_service.dto.MedicalRecordResponse;
import com.example.mcc_patient_service.exeption.ResourceNotFound;
import com.example.mcc_patient_service.model.MedicalRecord;
import com.example.mcc_patient_service.repository.MedicalRecordRepository;
import com.example.mcc_patient_service.service.MedicalRecordService;
import com.example.mcc_patient_service.util.MedicalRecordMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class MedicalRecordServiceImpl implements MedicalRecordService {
    private final MedicalRecordMapper medicalRecordMapper;
    private final MedicalRecordRepository medicalRecordRepository;
    @Override
    public List<MedicalRecordResponse> getAllMedicalRecord() {
        return medicalRecordMapper.toDtoList(medicalRecordRepository.findAll());
    }

    @Override
    public MedicalRecordResponse getMedicalRecordById(Long id) {
        return medicalRecordMapper.toDto(medicalRecordRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("alert action not found with id: " + id)
        ));
    }

    @Override
    public MedicalRecordResponse createMedicalRecord(MedicalRecordRequest medicalRecordRequest) {
        return medicalRecordMapper.toDto(medicalRecordRepository.save(medicalRecordMapper.toEntity(medicalRecordRequest)));
    }


    @Override
    public MedicalRecordResponse updateMedicalRecord(Long id, MedicalRecordRequest medicalRecordRequest) {
        MedicalRecord medicalRecordFound = medicalRecordRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("alert action not found with id: " + id)
        );
        medicalRecordFound.setPatient(medicalRecordMapper.toEntity(medicalRecordRequest).getPatient());
        medicalRecordFound.setDescription(medicalRecordRequest.description());
        medicalRecordFound.setDiagnosis(medicalRecordRequest.diagnosis());
        return medicalRecordMapper.toDto(medicalRecordRepository.save(medicalRecordFound));
    }

    @Override
    public void deleteMedicalRecord(Long id) {
        MedicalRecord medicalRecordFound = medicalRecordRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("alert action not found with id: " + id)
        );
        medicalRecordRepository.delete(medicalRecordFound);
    }
}
