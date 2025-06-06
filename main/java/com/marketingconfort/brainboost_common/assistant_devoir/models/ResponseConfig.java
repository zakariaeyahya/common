package com.marketingconfort.brainboost_common.assistant_devoir.models;

import com.marketingconfort.brainboost_common.assistantmanagement.models.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "response_config")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseConfig extends BaseEntity {

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

    @Column(name = "indice_level", nullable = false)
    private Integer indiceLevel = 0;
}