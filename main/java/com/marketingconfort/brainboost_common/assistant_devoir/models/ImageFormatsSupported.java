package com.marketingconfort.brainboost_common.assistant_devoir.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImageFormatsSupported {

    @Column(name = "pdf_supported")
    private Boolean PDF = false;

    @Column(name = "png_supported")
    private Boolean PNG = false;

    @Column(name = "jpg_supported")
    private Boolean JPG = false;
}