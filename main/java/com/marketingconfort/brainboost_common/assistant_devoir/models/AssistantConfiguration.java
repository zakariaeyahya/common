package com.marketingconfort.brainboost_common.assistant_devoir.models;

import com.marketingconfort.brainboost_common.assistantmanagement.models.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "assistant_configuration")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssistantConfiguration extends BaseEntity {

    @Column(name = "assistant_id", nullable = false)
    private Long assistantId;

    @Column(name = "config_type", length = 50, nullable = false)
    private String configType;

    @Column(name = "isActive ", nullable = false)
    private Boolean isActive  = true;

    @Column(name = "ai_model_id")
    private Long aiModelId;

    @Column(name = "rag_service_id")
    private Long ragServiceId;

    @Column(name = "embedding_service_id")
    private Long embeddingServiceId;

    @Column(name = "recherche_service_id")
    private Long rechercheServiceId;
}