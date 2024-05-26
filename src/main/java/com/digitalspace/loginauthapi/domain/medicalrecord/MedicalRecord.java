package com.digitalspace.loginauthapi.domain.medicalrecord;

import com.digitalspace.loginauthapi.domain.patient.Patient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "medical_records")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;

    private LocalDate creationDate;
    private String allergies;
    private Boolean cognitiveLimitations;
    private Boolean locomotionLimitations;
    private Boolean visionLimitations;
    private Boolean hearingLimitations;
    private String otherLimitations;
    private String consultationReason;
    private LocalDate nextSessionDate;
    private BigDecimal sessionValue;
    private String paymentMethod;
}
