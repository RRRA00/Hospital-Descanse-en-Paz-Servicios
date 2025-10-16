package com.example.mcc_patient_service.util;

import com.example.mcc_patient_service.dto.MedicalRecordRequest;
import com.example.mcc_patient_service.dto.MedicalRecordResponse;
import com.example.mcc_patient_service.model.MedicalRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",uses = {PatientMapper.class})
public interface MedicalRecordMapper {
    @Mapping(source = "patientId", target = "patient.id" )
    MedicalRecord toEntity(MedicalRecordRequest medicalRecordRequest);
    MedicalRecordResponse toDto(MedicalRecord medicalRecord);
    List<MedicalRecordResponse> toDtoList(List<MedicalRecord> medicalRecords);
}
