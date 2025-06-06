package com.marketingconfort.brainboost_common.assistant_devoir.enums;

import lombok.Getter;

@Getter
public enum AssistantStatus {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    MAINTENANCE("Under Maintenance"),
    DISABLED("Disabled");

    private final String displayName;

    AssistantStatus(String displayName) {
        this.displayName = displayName;
    }
}