package com.marketingconfort.brainboost_common.Payment.models;

import com.marketingconfort.brainboost_common.Payment.enums.InvoiceStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long parentId;
    private String gatewayInvoiceId;
    private String number;
    @Enumerated(EnumType.STRING)
    private InvoiceStatus status;
    private LocalDateTime invoiceDate;
    private LocalDateTime periodStart;
    private LocalDateTime periodEnd;
    private Long subtotal;
    private Long tax;
    private Long discount;
    private Long total;
    private String currency;
    private String hostedInvoiceUrl;
    private String invoicePdfUrl;
    private LocalDateTime nextPaymentAttempt;
    private LocalDateTime createdAt;
    @OneToOne(fetch=FetchType.LAZY, optional = true)
    @JoinColumn(name = "transaction_id", nullable = true)
    private Transaction transaction;
}
