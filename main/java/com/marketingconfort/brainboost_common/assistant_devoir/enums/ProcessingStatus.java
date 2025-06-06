package com.marketingconfort.brainboost_common.assistant_devoir.enums;

import lombok.Getter;

@Getter
public enum ProcessingStatus {
    PENDING("Pending"),
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed"),
    ERROR("Error"),
    FAILED("Failed");

    private final String displayName;

    ProcessingStatus(String displayName) {
        this.displayName = displayName;
    }
}