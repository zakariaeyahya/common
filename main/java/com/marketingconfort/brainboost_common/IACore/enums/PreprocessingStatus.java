package com.marketingconfort.brainboost_common.IACore.enums;

public enum PreprocessingStatus {
    PENDING("En attente"),
    PROCESSING("En cours"),
    COMPLETED("Terminé"),
    FAILED("Échoué");

    private final String displayName;

    PreprocessingStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getValue() {
        return this.name();
    }
}