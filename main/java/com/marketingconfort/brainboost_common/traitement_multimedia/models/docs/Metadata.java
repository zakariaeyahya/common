package com.marketingconfort.brainboost_common.traitement_multimedia.models.docs;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Metadata {

    @ManyToOne
    @JoinColumn(name = "image_document_id")
    private ImageDocument imageDocument;

    private String metadataKey;
    private String rawValue;
    private String dataType;
}