package com.marketingconfort.brainboost_common.traitement_multimedia.models.docs;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OCRResult {

    @ManyToOne
    @JoinColumn(name = "image_document_id")
    private ImageDocument imageDocument;

    @ManyToOne
    @JoinColumn(name = "ocr_config_id")
    private ConfigOCR ocrConfig;

    @ManyToOne
    @JoinColumn(name = "image_processing_id")
    private ImageProcessing imageProcessing;

    private String fullText;
    private Float confidence;
    private String detectedStructure;
    private String cachedFormulas;
    private String detectedLanguage;
}