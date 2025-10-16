package com.example.mcc_alert_service.controller;

import com.example.mcc_alert_service.dto.AlertRequest;
import com.example.mcc_alert_service.service.AlertService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alert")
@RequiredArgsConstructor
public class AlertController {
    private final AlertService alertService;
    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(alertService.getAllAlerts());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(alertService.getAlertById(id));
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid AlertRequest alertRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alertService.createAlert(alertRequest));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid AlertRequest alertRequest) {
        return ResponseEntity.ok(alertService.updateAlert(id, alertRequest));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        alertService.deleteAlert(id);
        return ResponseEntity.noContent().build();
    }
}
