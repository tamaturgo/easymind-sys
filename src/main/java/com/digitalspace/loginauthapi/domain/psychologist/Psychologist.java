package com.digitalspace.loginauthapi.domain.psychologist;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.digitalspace.loginauthapi.domain.user.User;
import com.digitalspace.loginauthapi.domain.signature.Signature;
import com.digitalspace.loginauthapi.domain.appointment.Appointment;

import java.time.LocalDate;
import java.util.UUID;
import java.util.List;
@Entity
@Table(name = "psychologists")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Psychologist {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "signature_id", referencedColumnName = "id")
    private Signature signature;

    @OneToMany(mappedBy = "psychologist")
    private List<Appointment> appointments;

    private String crpState;
    private String crpNumber;
    private String crpType;
    private String crpStatus;
    @Column(columnDefinition = "DATE")
    private LocalDate crpValidity;
    private String pixType;
    private String pixValue;
}
