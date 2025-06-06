package com.marketingconfort.brainboost_common.subscriptions.models;

import com.marketingconfort.brainboost_common.subscriptions.enums.DurationPeriod;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PricingPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;

    @Enumerated(EnumType.STRING)
    private DurationPeriod duration;

    private Double amount;
    private String gatewayPriceId;

    @OneToMany(mappedBy = "pricingPlan")
    private List<Subscription> subscriptions;

}