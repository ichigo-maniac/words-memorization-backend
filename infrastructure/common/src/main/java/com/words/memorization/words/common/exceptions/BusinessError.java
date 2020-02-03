package com.words.memorization.words.common.exceptions;

public enum BusinessError {

    E000("Error has been occurred during processing");

    private final String description;

    BusinessError(String description) {
        this.description = description;
    }

    public String getCode() {
        return name();
    }

    public String getDescription() {
        return description;
    }
}
