package com.marketingconfort.brainboost_common.IACore.models;

import com.marketingconfort.brainboost_common.IACore.enums.PreprocessingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pretraitement_document")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PretraitementDocument {
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

    @Column(name = "document_path", length = 255, nullable = false)
    private String documentPath;

    @Column(name = "document_type", length = 50, nullable = false)
    private String documentType;

    @Column(name = "preprocessing_status", length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private PreprocessingStatus preprocessingStatus = PreprocessingStatus.PENDING;

    @Column(name = "chunk_size", nullable = false)
    private Integer chunkSize = 1000;

    // Relations bidirectionnelles
    @OneToMany(mappedBy = "preprocessing", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DocumentChunk> chunks;

    @OneToMany(mappedBy = "pretraitement", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DocumentMetadata> metadataEntries;

    // Getters manuels pour garantir la disponibilité
    public Long getId() { return id; }
    public String getDocumentPath() { return documentPath; }
    public String getDocumentType() { return documentType; }
    public PreprocessingStatus getPreprocessingStatus() { return preprocessingStatus; }
    public Integer getChunkSize() { return chunkSize; }
    public List<DocumentChunk> getChunks() { return chunks; }
    public List<DocumentMetadata> getMetadataEntries() { return metadataEntries; }

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
        return "Document " + id + " - " + documentPath + " (" + preprocessingStatus + ")";
    }
}