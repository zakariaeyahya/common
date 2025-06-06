package com.marketingconfort.brainboost_common.subscriptions.models;

import com.marketingconfort.brainboost_common.subscriptions.enums.PublishType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Plan  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String shortDescription;
    private String fullDescription;
    private Integer nbr_children_access;
    private Integer question_par_assistant_par_day;
    private Integer nbr_subjects;

    @Enumerated(EnumType.STRING)
    private PublishType publish;

    private Date createdAt;
    private Date lastUpdate;
    private Date archivedAt;
    private Date expiredAt;

    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL)
    private List<PricingPlan> pricingPlans;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "assistant_configuration_id")
    private AssistantConfiguration assistants;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "discount_id")
    private Discount discount;
}