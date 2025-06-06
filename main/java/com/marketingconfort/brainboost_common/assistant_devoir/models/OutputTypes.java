package com.marketingconfort.brainboost_common.assistant_devoir.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OutputTypes {

    @Column(name = "text_output")
    private Boolean text = true;

    @Column(name = "audio_output")
    private Boolean audio = false;
}