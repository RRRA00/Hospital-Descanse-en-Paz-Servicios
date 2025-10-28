package com.example.mcc_divice_service.controller;

import com.example.mcc_divice_service.dto.VitalSignRequest;
import com.example.mcc_divice_service.service.VitalSignService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vital-sign")
public class VitalSignController {
    private final VitalSignService vitalSignService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(vitalSignService.getAllVitalSign());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(vitalSignService.getVitalSignById(id));
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid VitalSignRequest vitalSignRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vitalSignService.createVitalSign(vitalSignRequest));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid VitalSignRequest vitalSignRequest) {
        return ResponseEntity.ok(vitalSignService.updateVitalSign(id, vitalSignRequest));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        vitalSignService.deleteVitalSign(id);
        return ResponseEntity.noContent().build();
    }
}
