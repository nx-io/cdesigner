package com.cdesigner.constant;

public enum UserStatus {

    ACTIVE("active"),

    BANNED("banned"),

    DELETED("deleted");

    private UserStatus(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
