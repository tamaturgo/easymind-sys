package com.digitalspace.loginauthapi.domain.signature;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.digitalspace.loginauthapi.domain.user.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "signature_payments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignaturePayment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "signature_id", referencedColumnName = "id")
    private Signature signature;

    private String asaasPaymentId;
    private BigDecimal value;
    private String status;
    private Boolean isCanceled;
    private LocalDate createdAt;
    private LocalDate canceledAt;
    private LocalDate paymentDate;
    private LocalDate expirationDate;
    private Boolean isExpired;
}
