package com.marketingconfort.brainboost_common.assistant_devoir.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InputTypes {

    @Column(name = "text_input")
    private Boolean text = true;

    @Column(name = "audio_input")
    private Boolean audio = false;

    @Column(name = "image_input")
    private Boolean image = false;
}