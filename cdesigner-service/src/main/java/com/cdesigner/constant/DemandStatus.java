package com.cdesigner.constant;

public enum DemandStatus {
    ACTIVE("active"),

    INACTIVE("inactive"),

    DELETED("deleted");

    private DemandStatus(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
