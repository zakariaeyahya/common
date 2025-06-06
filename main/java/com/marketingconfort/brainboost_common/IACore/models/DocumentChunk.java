package com.marketingconfort.brainboost_common.IACore.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "document_chunk", indexes = {
        @Index(name = "idx_source_id", columnList = "source_id"),
        @Index(name = "idx_type", columnList = "type"),
        @Index(name = "idx_position", columnList = "position")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentChunk {
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

    @Column(name = "texte", columnDefinition = "TEXT", nullable = false)
    private String texte;

    @Column(name = "source_id", length = 100, nullable = false)
    private String sourceId;

    @Lob
    @Column(name = "embedding")
    private byte[] embedding;

    @Column(name = "score_reranking", nullable = false)
    private Float scoreReranking = 0.0f;

    @Column(name = "position", nullable = false)
    private Integer position;

    @Column(name = "type", length = 50, nullable = false)
    private String type;

    @Column(name = "educational_content_id")
    private Long educationalContentId;

    // Relation ManyToOne avec PretraitementDocument
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "preprocessing_id", nullable = false)
    private PretraitementDocument preprocessing;

    @Column(name = "embedding_id")
    private Long embeddingId;

    @Column(name = "vector_database_id")
    private Long vectorDatabaseId;

    // Getters manuels pour garantir la disponibilité
    public Long getId() { return id; }
    public String getTexte() { return texte; }
    public String getSourceId() { return sourceId; }
    public Integer getPosition() { return position; }
    public String getType() { return type; }
    public PretraitementDocument getPreprocessing() { return preprocessing; }
    public Float getScoreReranking() { return scoreReranking; }
    public byte[] getEmbedding() { return embedding; }

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
        lastModificationDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        lastModificationDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Chunk " + id + " - Doc " + (preprocessing != null ? preprocessing.getId() : "null") + " - Pos " + position;
    }
}