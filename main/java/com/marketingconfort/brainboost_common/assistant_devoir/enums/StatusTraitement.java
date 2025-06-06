package com.marketingconfort.brainboost_common.assistant_devoir.enums;

import lombok.Getter;

@Getter
public enum StatusTraitement {
    EN_ATTENTE("En attente"),
    EN_COURS("En cours de traitement"),
    TERMINE("Terminé"),
    ERREUR("Erreur"),
    ECHEC("Échec");

    private final String displayName;

    StatusTraitement(String displayName) {
        this.displayName = displayName;
    }

}