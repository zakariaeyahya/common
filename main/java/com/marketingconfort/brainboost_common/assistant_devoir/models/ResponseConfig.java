package com.marketingconfort.brainboost_common.assistant_devoir.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "response_config")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "config_id", nullable = false)
    private Long configId;

    @Embedded
    private InputTypes inputTypes;

    @Embedded
    private OutputTypes outputTypes;

    @Column(name = "welcome_message", columnDefinition = "TEXT")
    private String welcomeMessage;

    @ElementCollection
    @CollectionTable(
            name = "response_config_motivational_phrases",
            joinColumns = @JoinColumn(name = "config_id")
    )
    @Column(name = "phrase")
    private List<String> motivationalPhrases;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "last_modification_date", nullable = false)
    private LocalDateTime lastModificationDate;

    @Column(name = "last_modifier_id", nullable = false)
    private Long lastModifierId;

    @Column(name = "indice_level", nullable = false)
    private Integer indiceLevel = 0;

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