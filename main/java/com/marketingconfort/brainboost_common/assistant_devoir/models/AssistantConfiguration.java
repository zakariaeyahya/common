package com.marketingconfort.brainboost_common.assistant_devoir.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "assistant_configuration")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssistantConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "assistant_id", nullable = false)
    private Long assistantId;

    @Column(name = "config_type", length = 50, nullable = false)
    private String configType;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled = true;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "last_modification_date", nullable = false)
    private LocalDateTime lastModificationDate;

    @Column(name = "creator_id", nullable = false)
    private Long creatorId;

    @Column(name = "last_modifier_id", nullable = false)
    private Long lastModifierId;

    @Column(name = "ai_model_id")
    private Long aiModelId;

    @Column(name = "rag_service_id")
    private Long ragServiceId;

    @Column(name = "embedding_service_id")
    private Long embeddingServiceId;

    @Column(name = "recherche_service_id")
    private Long rechercheServiceId;

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
        lastModificationDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        lastModificationDate = LocalDateTime.now();
    }
}