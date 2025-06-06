package com.marketingconfort.brainboost_common.traitement_multimedia.models.docs;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImageDocument  {

    @Column(name = "user_id")
    private Long userId;

    private String imageFormat;
    private String path;
    private Long size;
    private Integer width;
    private Integer height;
    private String status;
    private String extractedText;
}