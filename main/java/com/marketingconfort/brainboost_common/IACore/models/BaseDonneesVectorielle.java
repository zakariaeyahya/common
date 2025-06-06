package com.marketingconfort.brainboost_common.IACore.models;

import com.marketingconfort.brainboost_common.IACore.enums.IndexType;
import com.marketingconfort.brainboost_common.IACore.enums.MetricType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "base_donnees_vectorielle", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"collection_name"})
})
@Getter
@Setter
@NoArgsConstructor
public class BaseDonneesVectorielle {
    // AJOUT: Champ ID manquant
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

    @Column(name = "collection_name", nullable = false, unique = true, length = 100)
    private String collectionName;

    @Column(name = "vector_size", nullable = false)
    private Integer vectorSize = 768;

    @Enumerated(EnumType.STRING)
    @Column(name = "index_type", nullable = false, length = 20)
    private IndexType indexType = IndexType.HNSW;

    @Column(name = "total_vectors", nullable = false)
    private Integer totalVectors = 0;

    @Enumerated(EnumType.STRING)
    @Column(name = "metric_type", nullable = false, length = 20)
    private MetricType metricType = MetricType.COSINE;

    @Override
    public String toString() {
        return String.format("Collection '%s' (%s, %s)", collectionName, indexType.name(), metricType.name());
    }
}
