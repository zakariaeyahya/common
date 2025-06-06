package com.marketingconfort.brainboost_common.Payment.enums;

public enum TransactionStatus {
    PENDING,
    REQUIRES_PAYMENT_METHOD,
    REQUIRES_ACTION,
    PROCESSING,
    SUCCEEDED,
    CANCELED,
    PAID,
    UNPAID,
    FAILED
}
