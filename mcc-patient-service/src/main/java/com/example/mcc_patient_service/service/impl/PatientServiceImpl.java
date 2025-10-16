package com.example.mcc_patient_service.service.impl;

import com.example.mcc_patient_service.dto.PatientRequest;
import com.example.mcc_patient_service.dto.PatientResponse;
import com.example.mcc_patient_service.exeption.ResourceNotFound;
import com.example.mcc_patient_service.model.Patient;
import com.example.mcc_patient_service.repository.PatientRepository;
import com.example.mcc_patient_service.service.PatientService;
import com.example.mcc_patient_service.util.PatientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientMapper patientMapper;
    private final PatientRepository patientRepository;
    @Override
    public List<PatientResponse> getAllPatient() {
        return patientMapper.toDtoList(patientRepository.findAll());
    }

    @Override
    public PatientResponse getPatientById(Long id) {
        return patientMapper.toDto(patientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("alert action not found with id: " + id)
        ));
    }

    @Override
    public PatientResponse createPatient(PatientRequest patientRequest) {
        return patientMapper.toDto(patientRepository.save(patientMapper.toEntity(patientRequest)));
    }

    @Override
    public PatientResponse updatePatient(Long id, PatientRequest patientRequest) {
        Patient patientFound = patientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("patient action not found with id: " + id)
        );
        patientFound.setDocumentNumber(patientRequest.documentNumber());
        patientFound.setFirstName(patientRequest.firstName());
        patientFound.setLastName(patientRequest.lastName());
        patientFound.setGender(patientRequest.gender());
        patientFound.setEmail(patientRequest.email());
        patientFound.setPhone(patientRequest.phone());
        patientFound.setActive(patientRequest.active());

        return patientMapper.toDto(patientRepository.save(patientFound));
    }

    @Override
    public void deletePatient(Long id) {
        Patient patientFound = patientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("patient action not found with id: " + id)
        );
        patientRepository.delete(patientFound);

    }
}
