package com.marketingconfort.brainboost_common.IACore.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "rag", indexes = {
        @Index(name = "idx_modele_generation", columnList = "modele_generation"),
        @Index(name = "idx_strategie_reranking", columnList = "strategie_reranking"),
        @Index(name = "idx_temperature", columnList = "temperature")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RAG {
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

    @Column(name = "modele_generation", length = 100, nullable = false)
    private String modeleGeneration;

    @Column(name = "taille_contexte_max", nullable = false)
    private Integer tailleContexteMax = 4000;

    @Column(name = "temperature", nullable = false)
    private Float temperature = 0.7f;

    @Column(name = "top_k", nullable = false)
    private Integer topK = 5;

    @Column(name = "strategie_reranking", length = 30, nullable = false)
    @Enumerated(EnumType.STRING)
    private StrategieReranking strategieReranking = StrategieReranking.MAXIMAL_MARGINAL_RELEVANCE;

    @Column(name = "filtre_contenu", length = 255)
    private String filtreContenu;

    // Relation avec BaseDonneesVectorielle
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "base_vectorielle_id")
    private BaseDonneesVectorielle baseVectorielle;

    // Relations bidirectionnelles
    @OneToMany(mappedBy = "rag", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Search> searches;

    @OneToMany(mappedBy = "rag", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EvaluationModeles> evaluationModeles;

    @OneToMany(mappedBy = "rag", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PerformanceMetricsRAG> metrics;

    // Getters manuels pour garantir la disponibilité (au cas où Lombok ne fonctionne pas)
    public Long getId() { return id; }
    public String getModeleGeneration() { return modeleGeneration; }
    public Integer getTailleContexteMax() { return tailleContexteMax; }
    public Float getTemperature() { return temperature; }
    public Integer getTopK() { return topK; }
    public StrategieReranking getStrategieReranking() { return strategieReranking; }
    public String getFiltreContenu() { return filtreContenu; }
    public BaseDonneesVectorielle getBaseVectorielle() { return baseVectorielle; }
    public List<Search> getSearches() { return searches; }
    public List<EvaluationModeles> getEvaluationModeles() { return evaluationModeles; }
    public List<PerformanceMetricsRAG> getMetrics() { return metrics; }

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
        return "RAG " + id + " - Model: " + modeleGeneration;
    }

    // Enum pour la stratégie de reranking
    public enum StrategieReranking {
        MAXIMAL_MARGINAL_RELEVANCE("MMR"),
        SEMANTIC_SIMILARITY("Similarité sémantique"),
        FUSION("Fusion");

        private final String displayName;

        StrategieReranking(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }
}