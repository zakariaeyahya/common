package com.marketingconfort.brainboost_common.assistant_devoir.models;

import com.marketingconfort.brainboost_common.assistantmanagement.models.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "language_settings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LanguageSettings extends BaseEntity {

    @Column(name = "creator_id", nullable = false)
    private Long creatorId;

    @Column(name = "last_modifier_id", nullable = false)
    private Long lastModifierId;

    @Column(name = "assistant_id", nullable = false)
    private Long assistantId;

    @Column(name = "primary_language_id", nullable = false)
    private Long primaryLanguageId;

    @Column(name = "secondary_language_id")
    private Long secondaryLanguageId;

    @Column(name = "communication_tone_id", nullable = false)
    private Long communicationToneId;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
}
