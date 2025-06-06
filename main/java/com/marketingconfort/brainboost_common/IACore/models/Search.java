package com.marketingconfort.brainboost_common.IACore.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marketingconfort.brainboost_common.IACore.enums.SearchType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "recherche_service", indexes = {
        @Index(name = "idx_search_type", columnList = "search_type"),
        @Index(name = "idx_education_level", columnList = "education_level"),
        @Index(name = "idx_created_date", columnList = "created_date")
})
@Getter
@Setter
@NoArgsConstructor
public class Search {
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

    @Column(name = "education_level", length = 50, nullable = false)
    private String educationLevel;

    @Column(name = "search_type", length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private SearchType searchType = SearchType.HYBRID;

    @Column(name = "result_limit", nullable = false)
    private Integer resultLimit = 10;

    @Column(name = "minimum_score", nullable = false)
    private Float minimumScore = 0.0f;

    @Column(name = "filters", columnDefinition = "TEXT", nullable = false)
    private String filters = "{}";

    // AJOUT: Relation avec RAG manquante
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rag_id")
    private RAG rag;

    @OneToMany(mappedBy = "search", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SearchResult> results;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    // AJOUT: Méthodes équivalentes aux méthodes Python
    public Map<String, Object> getFiltersDict() {
        if (filters == null || filters.isEmpty() || "{}".equals(filters)) {
            return new HashMap<>();
        }
        try {
            return objectMapper.readValue(filters, Map.class);
        } catch (JsonProcessingException e) {
            return new HashMap<>();
        }
    }

    public void setFiltersDict(Map<String, Object> filtersDict) {
        try {
            this.filters = objectMapper.writeValueAsString(filtersDict);
        } catch (JsonProcessingException e) {
            this.filters = "{}";
        }
    }

    // AJOUT: Propriété équivalente à search_results
    public List<SearchResult> getSearchResults() {
        return this.results;
    }

    @Override
    public String toString() {
        return "Recherche " + id + " - Type: " + searchType + ", Level: " + educationLevel;
    }
}