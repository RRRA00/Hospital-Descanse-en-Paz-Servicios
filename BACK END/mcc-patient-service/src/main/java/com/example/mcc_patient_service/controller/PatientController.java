package com.example.mcc_patient_service.controller;

import com.example.mcc_patient_service.dto.PatientRequest;
import com.example.mcc_patient_service.messaging.VitalSignPublisher;
import com.example.mcc_patient_service.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;
    private final VitalSignPublisher publisher;


    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(patientService.getAllPatient());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.getPatientById(id));
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid PatientRequest patientRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.createPatient(patientRequest));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid PatientRequest patientRequest) {
        return ResponseEntity.ok(patientService.updatePatient(id, patientRequest));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}
