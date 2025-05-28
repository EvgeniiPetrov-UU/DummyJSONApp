package com.example.dummyjsonapp.models.entity;

public enum AvailabilityStatus {

    IN_STOCK("In Stock"), LOW_STOCK("Low Stock");

    private final String value;

    AvailabilityStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
