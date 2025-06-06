package com.marketingconfort.brainboost_common.IACore.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum SearchType {
    VECTOR("VECTOR"),
    LEXICAL("LEXICAL"),
    HYBRID("HYBRID");

    private final String value;

    private static final Map<String, String> displayNames = new HashMap<>();

    static {
        displayNames.put("VECTOR", "Vectorielle");
        displayNames.put("LEXICAL", "Lexicale");
        displayNames.put("HYBRID", "Hybride");
    }

    SearchType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static List<Map.Entry<String, String>> choices() {
        return Arrays.stream(values())
                .map(type -> Map.entry(type.getValue(), type.name()))
                .collect(Collectors.toList());
    }

    public static List<Map.Entry<String, String>> displayChoices() {
        return Arrays.stream(values())
                .map(type -> Map.entry(type.getValue(), displayNames.get(type.name())))
                .collect(Collectors.toList());
    }

    public static SearchType fromValue(String value) {
        for (SearchType type : values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        return HYBRID;
    }
}
