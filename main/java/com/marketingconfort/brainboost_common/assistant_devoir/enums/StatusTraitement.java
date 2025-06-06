package com.marketingconfort.brainboost_common.assistant_devoir.enums;

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

    public String getDisplayName() {
        return displayName;
    }
}