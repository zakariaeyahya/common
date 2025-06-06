package com.marketingconfort.brainboost_common.assistant_devoir.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AudioFormatsSupported {

    @Column(name = "mp3_supported")
    private Boolean MP3 = false;

    @Column(name = "wav_supported")
    private Boolean WAV = false;

    @Column(name = "aac_supported")
    private Boolean AAC = false;
}