package com.example.mcc_divice_service.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "devices")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "serial_number", nullable = false, unique = true, length = 50)
    private String serialNumber;

    @Column(nullable = false, length = 50)
    private String type;  // Ejemplo: ECG, Termómetro, Oxímetro

    @Column(nullable = false)
    private Boolean status = true;  // Activo o fuera de servicio

    @Column(name = "assigned_patient_id")
    private Long assignedPatientId; // ID lógico del paciente (microservicio de pacientes)

    @Column(length = 100)
    private String location;

    @Column(name = "last_check", nullable = false, updatable = false,
            columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP", insertable = false)
    private LocalDateTime lastCheck;

    // Relación uno a muchos con VitalSign
    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VitalSign> vitalSigns;
}
