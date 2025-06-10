package com.example.dummyjsonapp.models.dto.product;

import java.time.Instant;

public record ReviewDto(
        Byte rating,
        String comment,
        Instant date,
        String reviewerName,
        String reviewerEmail
) {}
