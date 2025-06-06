package com.marketingconfort.brainboost_common.traitement_multimedia.models.docs;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImageProcessing  {

    private Long creatorId;
    private Long lastModifierId;
    private String supportedFormats;
    private String visionModel;
    private Float minimumQuality;
}
