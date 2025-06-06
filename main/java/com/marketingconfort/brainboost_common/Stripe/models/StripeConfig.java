package com.marketingconfort.brainboost_common.Stripe.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StripeConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean vaulting;
    private boolean threeDSecureRequired;
    private String  testApiSecretKey;
    private String  testApiPublishableKey;
    private String  liveApiSecretKey;
    private String  liveApiPublishableKey;
    private boolean liveMode;
}
