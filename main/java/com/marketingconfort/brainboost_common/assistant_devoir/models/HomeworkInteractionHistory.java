package com.marketingconfort.brainboost_common.assistant_devoir.models;

import com.marketingconfort.brainboost_common.assistantmanagement.models.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "historique_interactions_devoir")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HomeworkInteractionHistory extends BaseEntity {

    @Column(name = "user_id", nullable = false, unique = true)
    private Long userId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "historique_id")
    private List<HomeworkInteraction> interactions;
}