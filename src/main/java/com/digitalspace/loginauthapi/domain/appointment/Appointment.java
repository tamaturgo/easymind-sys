package com.digitalspace.loginauthapi.domain.appointment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.digitalspace.loginauthapi.domain.patient.Patient;
import com.digitalspace.loginauthapi.domain.psychologist.Psychologist;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "psychologist_id", referencedColumnName = "id")
    private Psychologist psychologist;

    private LocalDateTime date;
    private String time;
    private String status;

    @Enumerated(EnumType.STRING)
    private AppointmentType type;

    private String description;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isDeleted;
}
