package com.marketingconfort.brainboost_common.assistant_devoir.enums;

public enum AssistantStatus {
    ACTIVE("Actif"),
    INACTIVE("Inactif"),
    MAINTENANCE("En maintenance"),
    DISABLED("Désactivé");

    private final String displayName;

    AssistantStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}