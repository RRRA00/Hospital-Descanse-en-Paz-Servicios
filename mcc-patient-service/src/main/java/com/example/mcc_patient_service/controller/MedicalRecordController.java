package com.example.mcc_patient_service.controller;

import com.example.mcc_patient_service.dto.MedicalRecordRequest;
import com.example.mcc_patient_service.service.MedicalRecordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/medical-record")
public class MedicalRecordController {
    private final MedicalRecordService medicalRecordService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(medicalRecordService.getAllMedicalRecord());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(medicalRecordService.getMedicalRecordById(id));
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid MedicalRecordRequest medicalRecordRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(medicalRecordService.createMedicalRecord(medicalRecordRequest));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid MedicalRecordRequest medicalRecordRequest) {
        return ResponseEntity.ok(medicalRecordService.updateMedicalRecord(id, medicalRecordRequest));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        medicalRecordService.deleteMedicalRecord(id);
        return ResponseEntity.noContent().build();
    }
}
