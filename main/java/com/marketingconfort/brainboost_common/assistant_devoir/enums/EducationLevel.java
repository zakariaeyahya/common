package com.marketingconfort.brainboost_common.assistant_devoir.enums;

import lombok.Getter;

@Getter
public enum EducationLevel {
    CP("Preparatory Course"),
    CE1("Elementary Course 1"),
    CE2("Elementary Course 2"),
    CM1("Middle Course 1"),
    CM2("Middle Course 2") ;
    private final String displayName;

    EducationLevel(String displayName) {
        this.displayName = displayName;
    }
}