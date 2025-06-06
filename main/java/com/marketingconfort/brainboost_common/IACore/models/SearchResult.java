package com.marketingconfort.brainboost_common.IACore.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "search_result", indexes = {
        @Index(name = "idx_score", columnList = "score"),
        @Index(name = "idx_source", columnList = "source"),
        @Index(name = "idx_vector_id", columnList = "vector_id"),
        @Index(name = "idx_created_date", columnList = "created_date")
})
@Getter
@Setter
@NoArgsConstructor
public class SearchResult {
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

    @Column(name = "text", columnDefinition = "TEXT", nullable = false)
    private String text;

    @Column(name = "score", nullable = false)
    private Float score;

    @Column(name = "source", length = 255, nullable = false)
    private String source;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_chunk_id", nullable = false)
    private DocumentChunk documentChunk;

    @Column(name = "vector_id", length = 100)
    private String vectorId;

    @Column(name = "highlighted", nullable = false)
    private Boolean highlighted = false;

    @Column(name = "collection_source", length = 255, nullable = false)
    private String collectionSource;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "search_id", nullable = false)
    private Search search;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "base_vectorielle_id")
    private BaseDonneesVectorielle baseVectorielle;
    @Override
    public String toString() {
        return "SearchResult " + id + " - Score: " + score + " - Source: " + source;
    }
}