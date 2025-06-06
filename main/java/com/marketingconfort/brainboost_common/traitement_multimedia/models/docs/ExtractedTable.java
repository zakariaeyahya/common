package com.marketingconfort.brainboost_common.traitement_multimedia.models.docs;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExtractedTable  {

    @ManyToOne
    @JoinColumn(name = "ocr_result_id")
    private OCRResult ocrResult;

    private Integer positionX;
    private Integer positionY;
    private Integer width;
    private Integer height;
    private Integer numberOfRows;
    private Integer numberOfColumns;
    private String cellContents;
    private Float extractionConfidence;
}
