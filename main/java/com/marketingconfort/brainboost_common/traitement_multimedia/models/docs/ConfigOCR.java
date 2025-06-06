package com.marketingconfort.brainboost_common.traitement_multimedia.models.docs;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConfigOCR  {

    @ManyToOne
    @JoinColumn(name = "image_processing_id")
    private ImageProcessing imageProcessing;

    private String name;
    private String model;
    private String languages;
    private Boolean detectTables;
    private Boolean detectFormulas;
    private Integer detailLevel;
    private Boolean academicOptimization;
}