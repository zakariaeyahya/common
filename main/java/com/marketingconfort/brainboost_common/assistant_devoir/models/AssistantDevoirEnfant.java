package com.marketingconfort.brainboost_common.assistant_devoir.models;

import com.marketingconfort.brainboost_common.assistant_devoir.enums.*;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "assistant_devoir_enfant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssistantDevoirEnfant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "last_modification_date", nullable = false)
    private LocalDateTime lastModificationDate;

    @Column(name = "creator_id", nullable = false)
    private Long creatorId;

    @Column(name = "last_modifier_id", nullable = false)
    private Long lastModifierId;

    @ElementCollection
    @CollectionTable(
            name = "assistant_supported_input_types",
            joinColumns = @JoinColumn(name = "assistant_id")
    )
    @Column(name = "input_type")
    private List<String> supportedInputTypes;

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