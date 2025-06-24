package com.example.dummyjsonapp.models.dto.product;

import com.example.dummyjsonapp.models.entity.AvailabilityStatus;
import com.example.dummyjsonapp.models.entity.ReturnPolicy;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public record ProductDto(
        Long id,
        String title,
        String description,
        String category,
        BigDecimal price,
        Double discountPercentage,
        Double rating,
        Integer stock,
        Set<String> tags,
        String brand,
        String sku,
        Double weight,
        DimensionsDto dimensions,
        String warrantyInformation,
        String shippingInformation,
        String availabilityStatus,
        List<ReviewDto> reviews,
        String returnPolicy,
        Integer minimumOrderQuantity,
        MetaDto meta,
        List<String> images,
        String thumbnail
) {}
