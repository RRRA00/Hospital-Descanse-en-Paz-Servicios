package com.example.mcc_patient_service.controller;

import com.example.mcc_patient_service.dto.VitalSignDTO;
import com.example.mcc_patient_service.messaging.VitalSignPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/vitals")
@RequiredArgsConstructor
public class VitalSignController {

    private final VitalSignPublisher publisher;

    @PostMapping
    public ResponseEntity<String> sendVitalSign(@RequestBody VitalSignDTO vitalSign) {
        publisher.publish(vitalSign);
        return ResponseEntity.ok("Signo vital enviado correctamente");
    }
}
