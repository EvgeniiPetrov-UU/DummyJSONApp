package com.example.dummyjsonapp.models.dto.product;

import java.time.ZonedDateTime;

public record MetaDto(
        ZonedDateTime createdAt,
        ZonedDateTime updatedAt,
        String barcode,
        String qrCode
) {}
