package com.example.dummyjsonapp.models.dto.product;

import java.time.Instant;

public record MetaDto(
        Instant createdAt,
        Instant updatedAt,
        String barcode,
        String qrCode
) {}
