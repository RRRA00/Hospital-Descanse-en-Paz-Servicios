package com.example.mcc_divice_service.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "vital_signs")
public class VitalSign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación con Device
    @ManyToOne
    @JoinColumn(name = "device_id", nullable = false)
    private Device device;

    @Column(name = "patient_id", nullable = false)
    private Long patientId; // Copiado desde patient-service

    @Column(precision = 5, scale = 2)
    private BigDecimal temperature;

    @Column(name = "heart_rate")
    private Long heartRate;

    @Column(name = "oxygen_level", precision = 5, scale = 2)
    private BigDecimal oxygenLevel;

    @Column(name = "blood_pressure", length = 20)
    private String bloodPressure;

    @Column(name = "measurement_time", nullable = false, updatable = false,
            columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP", insertable = false)
    private LocalDateTime measurementTime;
}

