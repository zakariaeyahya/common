package com.marketingconfort.brainboost_common.traitement_multimedia.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "traitement_parole")
public class SpeechProcessing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime lastModificationDate;
    private Long creatorId;
    private Long lastModifierId;
    private String sttModel;
    private String ttsModel;
    private String supportedLanguages;
    private String supportedFormats;

    @Enumerated(EnumType.STRING)
    private AudioQuality audioQuality;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "config_audio_id")
    private AudioConfig audioConfig;

    public enum AudioQuality {
        LOW, MEDIUM, HIGH, LOSSLESS
    }
}