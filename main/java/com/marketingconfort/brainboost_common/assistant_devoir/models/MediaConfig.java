package com.marketingconfort.brainboost_common.assistant_devoir.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "media_config")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MediaConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "config_id", nullable = false)
    private Long configId;

    @Embedded
    private ImageFormatsSupported imageFormatsSupported;

    @Embedded
    private AudioFormatsSupported audioFormatsSupported;

    @Column(name = "ocr_enabled", nullable = false)
    private Boolean ocrEnabled = false;

    @Column(name = "voice_transcription_enabled", nullable = false)
    private Boolean voiceTranscriptionEnabled = false;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "last_modification_date", nullable = false)
    private LocalDateTime lastModificationDate;

    @Column(name = "last_modifier_id", nullable = false)
    private Long lastModifierId;

    @Column(name = "ocr_service_id")
    private Long ocrServiceId;

    @Column(name = "parole_service_id")
    private Long paroleServiceId;

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
        lastModificationDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        lastModificationDate = LocalDateTime.now();
    }
}