package com.marketingconfort.brainboost_common.IACore.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
        name = "document_metadata",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"pretraitement_id", "key"})
        }
)
@Getter
@Setter
@NoArgsConstructor
public class DocumentMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pretraitement_id", nullable = false)
    private PretraitementDocument pretraitement;

    @Column(name = "key", length = 100, nullable = false)
    private String key;

    @Column(name = "value", columnDefinition = "TEXT", nullable = false)
    private String value;

    @Override
    public String toString() {
        return key + ": " + value;
    }

    public DocumentMetadata(PretraitementDocument pretraitement, String key, String value) {
        this.pretraitement = pretraitement;
        this.key = key;
        this.value = value;
    }
}
