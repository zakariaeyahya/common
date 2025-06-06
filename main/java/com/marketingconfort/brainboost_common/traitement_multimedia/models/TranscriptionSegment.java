package com.marketingconfort.brainboost_common.traitement_multimedia.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "segment_transcription")
public class TranscriptionSegment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resultat_transcription_id")
    private TranscriptionResult transcriptionResult;

    private String text;
    private Float startTimestamp;
    private Float endTimestamp;
    private String speaker;
    private Float confidence;
}