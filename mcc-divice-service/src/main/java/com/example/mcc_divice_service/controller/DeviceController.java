package com.example.mcc_divice_service.controller;

import com.example.mcc_divice_service.dto.DeviceRequest;
import com.example.mcc_divice_service.service.DeviceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/device")
public class DeviceController {
    private final DeviceService deviceService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(deviceService.getAllDevice());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(deviceService.getDeviceById(id));
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid DeviceRequest deviceRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(deviceService.createDevice(deviceRequest));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid DeviceRequest deviceRequest) {
        return ResponseEntity.ok(deviceService.updateDevice(id, deviceRequest));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        deviceService.deleteDevice(id);
        return ResponseEntity.noContent().build();
    }
}
