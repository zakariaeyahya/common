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
@Table(name = "config_audio")
public class AudioConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Integer sampleRate;
    private Integer channels;
    private Integer bitDepth;

    @Enumerated(EnumType.STRING)
    private CompressionType compression;

    private Boolean noiseReduction;
    private Boolean normalization;
    private LocalDateTime creationDate;
    private Long creatorId;

    public enum CompressionType {
        NONE, LOSSLESS, LOSSY
    }
}

