package com.marketingconfort.brainboost_common.assistant_devoir.enums;

import lombok.Getter;

@Getter
public enum SearchInputType {
    TEXT("Text"),
    IMAGE("Image"),
    AUDIO("Audio"),
    FILE("File");

    private final String displayName;

    SearchInputType(String displayName) {
        this.displayName = displayName;
    }
}