package com.example.dummyjsonapp.models.dto.product;

import java.time.ZonedDateTime;

public record ReviewDTO(
        Integer rating,
        String comment,
        ZonedDateTime date,
        String reviewerName,
        String reviewerEmail
) {}
