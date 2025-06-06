package com.marketingconfort.brainboost_common.IACore.models;

import com.marketingconfort.brainboost_common.IACore.enums.PreprocessingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "embedding", indexes = { // CORRECTION: nom de table
        @Index(name = "idx_modele_name", columnList = "modele_name"), // CORRECTION: nom de colonne
        @Index(name = "idx_processing_status", columnList = "processing_status"),
        @Index(name = "idx_created_date", columnList = "created_date")
})
@Getter
@Setter
@NoArgsConstructor
public class Embedding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "last_modification_date", nullable = false)
    private LocalDateTime lastModificationDate;

    @Column(name = "creator_id", nullable = false)
    private Long creatorId;

    @Column(name = "last_modifier_id", nullable = false)
    private Long lastModifierId;

    // CORRECTION: nom de colonne selon le modèle Python
    @Column(name = "modele_name", length = 100, nullable = false)
    private String modeleName = "all-mpnet-base-v2";

    @Column(name = "embedding_size", nullable = false)
    private Integer embeddingSize = 768;

    @Column(name = "batch_size", nullable = false)
    private Integer batchSize = 32;

    @Column(name = "processing_status", length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private PreprocessingStatus processingStatus = PreprocessingStatus.PENDING;

    @ManyToMany
    @JoinTable(
            name = "embedding_document_chunk", // Table de liaison pour ManyToMany
            joinColumns = @JoinColumn(name = "embedding_id"),
            inverseJoinColumns = @JoinColumn(name = "document_chunk_id")
    )
    private Set<DocumentChunk> chunks = new HashSet<>();

    @Override
    public String toString() {
        return "Embedding " + id + " - " + modeleName;
    }
}
