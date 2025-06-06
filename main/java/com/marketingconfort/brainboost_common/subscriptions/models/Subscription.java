package com.marketingconfort.brainboost_common.subscriptions.models;

import com.marketingconfort.brainboost_common.subscriptions.enums.StatusType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Subscription  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "pricing_plan_id",
            nullable = false
    )
    private PricingPlan pricingPlan;

    private String gateway_subscription_id;
    private String gateway_subscription_item_id;

    @Enumerated(EnumType.STRING)
    private StatusType status;

    private Date current_period_start;
    private Date current_period_end;
    private Double amount;
    private Integer numberQuestions;
    @Column(name = "parent_id", nullable = false)
    private Long parentId;
}
