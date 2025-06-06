package com.marketingconfort.brainboost_common.traitement_multimedia.models;

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
@Table(name = "resultat_transcription")
public class TranscriptionResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long audioId;
    private LocalDateTime processingDate;
    private String fullText;
    private Float confidence;
    private String speakers;
    private String language;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fichier_audio_id")
    private AudioFile audioFile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "traitement_parole_id")
    private SpeechProcessing speechProcessing;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "config_audio_id")
    private AudioConfig audioConfig;
}