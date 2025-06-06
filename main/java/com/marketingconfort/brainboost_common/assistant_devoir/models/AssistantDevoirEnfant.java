package com.marketingconfort.brainboost_common.assistant_devoir.models;

import com.marketingconfort.brainboost_common.assistant_devoir.enums.*;
import com.marketingconfort.brainboost_common.assistantmanagement.models.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "assistant_devoir_enfant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssistantDevoirEnfant extends BaseEntity {

    @Column(name = "creator_id", nullable = false)
    private Long creatorId;

    @Column(name = "last_modifier_id", nullable = false)
    private Long lastModifierId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "type", length = 50, nullable = false)
    private String type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private AssistantStatus status = AssistantStatus.ACTIVE;

    @Enumerated(EnumType.STRING)
    @Column(name = "education_level", nullable = false)
    private NiveauEducatif educationLevel;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled = true;

    @ElementCollection
    @CollectionTable(
            name = "assistant_supported_input_types",
            joinColumns = @JoinColumn(name = "assistant_id")
    )
    @Column(name = "input_type")
    private List<String> supportedInputTypes;
}