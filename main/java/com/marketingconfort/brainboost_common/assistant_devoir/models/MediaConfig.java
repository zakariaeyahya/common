package com.marketingconfort.brainboost_common.assistant_devoir.models;

import com.marketingconfort.brainboost_common.assistantmanagement.models.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "media_config")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MediaConfig extends BaseEntity {

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

    @Column(name = "ocr_service_id")
    private Long ocrServiceId;

    @Column(name = "parole_service_id")
    private Long paroleServiceId;
}