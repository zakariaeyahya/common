package com.marketingconfort.brainboost_common.Payment.models;

import com.marketingconfort.brainboost_common.Payment.enums.PaymentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment_details")
public class PaymentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Builder.Default
    private Long id=null;
    private Long parentId;
    @Enumerated(EnumType.STRING)
    private PaymentType type;
    private String lastFourDigits;
    private int expiryYear;
    private int expiryMonth;
    private String gatewayPaymentMethodId;
    private boolean defaultCard;
    private boolean active;
    private LocalDateTime createdAt;
    @OneToMany(mappedBy = "paymentDetails")
    private List<Transaction> transactions;
}