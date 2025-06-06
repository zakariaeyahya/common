package com.marketingconfort.brainboost_common.subscriptions.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssistantConfiguration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "devoir_id")
    private AssistantModule devoir;

    @ManyToOne
    @JoinColumn(name = "recherche_id")
    private AssistantModule recherche;

    @ManyToOne
    @JoinColumn(name = "japprends_id")
    private AssistantModule japprends;
}