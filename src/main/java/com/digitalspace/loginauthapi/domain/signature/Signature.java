package com.digitalspace.loginauthapi.domain.signature;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.digitalspace.loginauthapi.domain.user.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "signatures")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Signature {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "signature")
    private List<SignaturePayment> payments;

    private String paymentId;
    private String signatureType;
    private LocalDateTime expirationDate;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isCanceled;
}
