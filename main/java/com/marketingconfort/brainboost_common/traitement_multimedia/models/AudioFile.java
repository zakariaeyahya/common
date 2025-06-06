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
@Table(name = "fichier_audio")
public class AudioFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private LocalDateTime creationDate;
    private String format;
    private String path;
    private Integer size;
    private Float duration;
    private Integer bitrate;

    @Enumerated(EnumType.STRING)
    private FileStatus status;

    private String language;
    private String transcribedText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "traitement_parole_id")
    private SpeechProcessing speechProcessing;

    public enum FileStatus {
        UPLOADED, PROCESSING, PROCESSED, ERROR
    }
}