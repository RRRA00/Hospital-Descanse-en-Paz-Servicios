package com.example.mcc_alert_service.controller;

import com.example.mcc_alert_service.configuration.RabbitMQConfig;
import com.example.mcc_alert_service.dto.AlertActionRequest;
import com.example.mcc_alert_service.service.AlertActionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/alert-action")
public class AlertActionController {
    private final AlertActionService alertActionService;
    private RabbitTemplate template;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(alertActionService.getAllAlertActions());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(alertActionService.getAlertActionById(id));
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid AlertActionRequest alertActionRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alertActionService.createAlertAction(alertActionRequest));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid AlertActionRequest alertActionRequest) {
        return ResponseEntity.ok(alertActionService.updateAlertAction(id, alertActionRequest));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        alertActionService.deleteAlertAction(id);
        return ResponseEntity.noContent().build();
    }
}
