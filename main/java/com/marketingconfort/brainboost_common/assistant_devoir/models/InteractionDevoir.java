package com.marketingconfort.brainboost_common.assistant_devoir.models;

import com.marketingconfort.brainboost_common.assistant_devoir.enums.*;
import com.marketingconfort.brainboost_common.assistantmanagement.models.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "interaction_devoir")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InteractionDevoir extends BaseEntity {

    @Column(name = "creator_id", nullable = false)
    private Long creatorId;

    @Column(name = "last_modifier_id", nullable = false)
    private Long lastModifierId;

    @Column(name = "assistant_id", nullable = false)
    private Long assistantId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "query", columnDefinition = "TEXT", nullable = false)
    private String query;

    @Column(name = "response", columnDefinition = "TEXT")
    private String response;

    @Column(name = "interaction_type", length = 50, nullable = false)
    private String interactionType;

    @Column(name = "interaction_date", nullable = false)
    private LocalDateTime interactionDate;

    @Column(name = "is_redirected", nullable = false)
    private Boolean isRedirected = false;

    @Column(name = "redirected_to", length = 100)
    private String redirectedTo;

    @Enumerated(EnumType.STRING)
    @Column(name = "input_type", nullable = false)
    private TypeEntreeRecherche inputType = TypeEntreeRecherche.TEXT;

    @Column(name = "ocr_result_id")
    private Long ocrResultId;

    @Column(name = "transcription_result_id")
    private Long transcriptionResultId;

    @Enumerated(EnumType.STRING)
    @Column(name = "processing_status", nullable = false)
    private StatusTraitement processingStatus = StatusTraitement.EN_ATTENTE;

    @Lob
    @Column(name = "raw_input_data")
    private byte[] rawInputData;

    @Column(name = "processed_input_data", columnDefinition = "TEXT")
    private String processedInputData;

    @Column(name = "conversion_timestamp")
    private LocalDateTime conversionTimestamp;

    @PrePersist
    protected void onCreate() {
        if (interactionDate == null) {
            interactionDate = LocalDateTime.now();
        }
    }
}
