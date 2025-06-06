package com.marketingconfort.brainboost_common.IACore.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "evaluation_metrics")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationMetrics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "last_modification_date", nullable = false)
    private LocalDateTime lastModificationDate;

    @Column(name = "precision", nullable = false)
    private Float precision;

    @Column(name = "rappel", nullable = false)
    private Float rappel;

    @Column(name = "f1_score", nullable = false)
    private Float f1Score;

    @Column(name = "exact_match", nullable = false)
    private Float exactMatch;

    // Relation OneToOne bidirectionnelle avec EvaluationModeles
    @OneToOne(mappedBy = "evaluationMetrics")
    private EvaluationModeles evaluationModel;

    // Getters manuels pour garantir la disponibilité (au cas où Lombok ne fonctionne pas)
    public Long getId() { return id; }
    public Float getPrecision() { return precision; }
    public Float getF1Score() { return f1Score; }
    public Float getRappel() { return rappel; }
    public Float getExactMatch() { return exactMatch; }

    @Override
    public String toString() {
        return "Evaluation Metrics " + id + " - F1: " + f1Score + ", Precision: " + precision;
    }
}