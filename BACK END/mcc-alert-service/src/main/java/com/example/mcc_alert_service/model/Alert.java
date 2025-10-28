package com.example.mcc_alert_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "alerts")
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_id", nullable = false)
    private Long patientId; // ID del paciente (viene del patient-service)

    @Column(name = "device_id", nullable = false)
    private Long deviceId; // ID del dispositivo (viene del device-service)

    @Column(nullable = false, length = 100)
    private String type; // Ejemplo: "ALTA FRECUENCIA CARDIACA"

    @Column(nullable = false, length = 255)
    private String message;

    @Column(nullable = false, length = 20)
    private String level; // "CRITICAL", "WARNING", "INFO"

    @Column(nullable = false)
    private Boolean acknowledged = false; // Estado de reconocimiento

    @Column(name = "created_at", nullable = false,
            updatable = false,
            insertable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    // Relación uno a muchos: una alerta puede tener varias acciones
    @OneToMany(mappedBy = "alert", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AlertAction> actions;
}
