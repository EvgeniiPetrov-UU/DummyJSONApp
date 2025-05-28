package com.example.dummyjsonapp.models.entity;

public enum ReturnPolicy {

    NO_RETURN_POLICY("No return policy"), SEVEN_DAYS("7 days return policy"),
    THIRTY_DAYS("30 days return policy"), SIXTY_DAYS("60 days return policy"),
    NINETY_DAYS("90 days return policy");

    private final String value;

    ReturnPolicy(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
