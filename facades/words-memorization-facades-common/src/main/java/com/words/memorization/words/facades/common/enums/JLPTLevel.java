package com.words.memorization.words.facades.common.enums;

public enum JLPTLevel {

    N1("N1"),
    N2("N2"),
    N3("N3"),
    N4("N4"),
    N5("N5");

    private String value;

    JLPTLevel(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
