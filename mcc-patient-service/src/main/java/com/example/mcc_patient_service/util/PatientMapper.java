package com.example.mcc_patient_service.util;

import com.example.mcc_patient_service.dto.PatientRequest;
import com.example.mcc_patient_service.dto.PatientResponse;
import com.example.mcc_patient_service.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.jmx.export.annotation.ManagedNotification;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    Patient toEntity(PatientRequest patientRequest);
    PatientResponse toDto(Patient patient);
    List<PatientResponse> toDtoList(List<Patient> patients);
}
