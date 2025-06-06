package com.marketingconfort.brainboost_common.Payment.models;

import com.marketingconfort.brainboost_common.Payment.enums.TransactionStatus;
import com.marketingconfort.brainboost_common.subscriptions.models.Subscription;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    private Long parentId;
    private String currency;
    private String gatewayTransactionId;
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;
    private String gatewayInvoiceId;
    @Column(name = "subscription_id")
    private Long subscriptionId;
    private LocalDateTime createdAt;
    @OneToOne(mappedBy = "transaction", fetch=FetchType.LAZY)
    private Invoice invoice;
    @OneToOne(mappedBy = "transaction", fetch=FetchType.LAZY)
    private ExtraQuestionPurchase extraQuestionPurchase;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "payment_details_id")
    private PaymentDetails paymentDetails;
}
