package com.marketingconfort.brainboost_common.assistant_devoir.enums;

import lombok.Getter;

@Getter
public enum NiveauEducatif {
    CP("Cours Préparatoire"),
    CE1("Cours Élémentaire 1"),
    CE2("Cours Élémentaire 2"),
    CM1("Cours Moyen 1"),
    CM2("Cours Moyen 2"),
    SIXIEME("6ème"),
    CINQUIEME("5ème"),
    QUATRIEME("4ème"),
    TROISIEME("3ème"),
    SECONDE("2nde"),
    PREMIERE("1ère"),
    TERMINALE("Terminale");

    private final String displayName;

    NiveauEducatif(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}