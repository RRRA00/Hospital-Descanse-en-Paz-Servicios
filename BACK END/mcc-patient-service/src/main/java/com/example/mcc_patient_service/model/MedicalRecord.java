package com.example.mcc_patient_service.model;

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
@Table(name = "medical_records")
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación con paciente
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(length = 255)
    private String description;

    @Column(length = 255)
    private String diagnosis;

    @Column(name = "record_date", nullable = false,
            columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP",
            insertable = false, updatable = false)
    private LocalDateTime recordDate;
}

