package com.marketingconfort.brainboost_common.assistant_devoir.enums;

import lombok.Getter;

@Getter
public enum TypeEntreeRecherche {
    TEXT("Texte"),
    IMAGE("Image"),
    AUDIO("Audio"),
    FILE("Fichier");

    private final String displayName;

    TypeEntreeRecherche(String displayName) {
        this.displayName = displayName;
    }

}