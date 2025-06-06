package com.marketingconfort.brainboost_common.IACore.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "evaluation_modeles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationModeles {
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

    // Relation OneToOne avec EvaluationMetrics
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "evaluation_metrics_id", nullable = false)
    private EvaluationMetrics evaluationMetrics;

    // Relation ManyToOne avec Search
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "search_id")
    private Search search;

    // Relation ManyToOne avec RAG
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rag_id")
    private RAG rag;

    // Champs MLflow
    @Column(name = "mlflow_experiment_id", length = 100)
    private String mlflowExperimentId;

    @Column(name = "mlflow_run_id", length = 100)
    private String mlflowRunId;

    @Column(name = "mlflow_model_uri", length = 255)
    private String mlflowModelUri;

    @Column(name = "mlflow_model_version", length = 50)
    private String mlflowModelVersion;

    // Getters manuels pour garantir la disponibilité
    public Long getId() { return id; }
    public EvaluationMetrics getEvaluationMetrics() { return evaluationMetrics; }
    public Search getSearch() { return search; }
    public RAG getRag() { return rag; }

    @Override
    public String toString() {
        if (evaluationMetrics != null) {
            try {
                Float f1 = evaluationMetrics.getF1Score();
                Float precision = evaluationMetrics.getPrecision();
                if (f1 != null && precision != null) {
                    return String.format("F1: %.2f, Précision: %.2f", f1, precision);
                }
            } catch (Exception e) {
                // Handle any exception during metric access
                return "Evaluation Model " + id;
            }
        }
        return "Evaluation Model " + id;
    }

    // Méthodes utilitaires pour accéder aux métriques
    public Float getF1ScoreValue() {
        return evaluationMetrics != null ? evaluationMetrics.getF1Score() : null;
    }

    public Float getPrecisionValue() {
        return evaluationMetrics != null ? evaluationMetrics.getPrecision() : null;
    }
}