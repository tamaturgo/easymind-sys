package com.digitalspace.loginauthapi.domain.patient;

import com.digitalspace.loginauthapi.domain.appointment.Appointment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.digitalspace.loginauthapi.domain.user.User;
import com.digitalspace.loginauthapi.domain.psychologist.Psychologist;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "patients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    private String cpf;
    private String rg;
    private LocalDate birthDate;
    private String civilState;
    private String gender;
    private Boolean firstTimeTreatment;
    private Integer childrenQuantity = 0;
    private LocalDate treatmentStartDate;
}
