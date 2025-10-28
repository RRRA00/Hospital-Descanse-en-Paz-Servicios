package com.example.mcc_alert_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "alert_actions")
public class AlertAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación con la alerta
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alert_id", nullable = false)
    private Alert alert;

    @Column(nullable = false, length = 100)
    private String action; // Ejemplo: "NOTIFICAR MÉDICO", "ENVIAR SMS"

    @Column(name = "performed_by", length = 100)
    private String performedBy; // Usuario o sistema que ejecutó la acción

    @Column(name = "performed_at", nullable = false,
            updatable = false,
            insertable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime performedAt;
}
