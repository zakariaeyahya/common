package com.marketingconfort.brainboost_common.IACore.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "performance_metrics_rag", indexes = {
        @Index(name = "idx_relevance_score", columnList = "relevance_score"),
        @Index(name = "idx_is_valid_response", columnList = "is_valid_response"),
        @Index(name = "idx_timestamp", columnList = "timestamp"),
        @Index(name = "idx_rag", columnList = "rag_id"),
        @Index(name = "idx_created_date", columnList = "created_date")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PerformanceMetricsRAG {
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

    // Métriques de performance
    @Column(name = "relevance_score", nullable = false)
    private Float relevanceScore = 0.0f;

    @Column(name = "confidence_rate", nullable = false)
    private Float confidenceRate = 0.0f;

    @Column(name = "response_length", nullable = false)
    private Integer responseLength = 0;

    @Column(name = "generation_time", nullable = false)
    private Float generationTime = 0.0f;

    @Column(name = "context_coverage", nullable = false)
    private Float contextCoverage = 0.0f;

    @Column(name = "chunk_usage_rate", nullable = false)
    private Float chunkUsageRate = 0.0f;

    @Column(name = "is_valid_response", nullable = false)
    private Boolean isValidResponse = true;

    @Column(name = "number_of_matched_keywords", nullable = false)
    private Integer numberOfMatchedKeywords = 0;

    // Relation avec RAG
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rag_id")
    private RAG rag;

    // Informations additionnelles
    @Column(name = "query_id", length = 100)
    private String queryId;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;

    // Getters manuels pour garantir la disponibilité
    public Long getId() { return id; }
    public RAG getRag() { return rag; }
    public Float getRelevanceScore() { return relevanceScore; }

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
        lastModificationDate = LocalDateTime.now();
        if (timestamp == null) {
            timestamp = LocalDateTime.now();
        }
    }

    @PreUpdate
    protected void onUpdate() {
        lastModificationDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Metrics " + id + " - RAG " + (rag != null ? rag.getId() : "null") + " - Score: " + relevanceScore;
    }
}