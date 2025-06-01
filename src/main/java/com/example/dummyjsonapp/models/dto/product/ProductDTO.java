package com.example.dummyjsonapp.models.dto.product;

import com.example.dummyjsonapp.models.entity.AvailabilityStatus;
import com.example.dummyjsonapp.models.entity.ReturnPolicy;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public record ProductDTO(
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
        DimensionsDTO dimensions,
        String warrantyInformation,
        String shippingInformation,
        AvailabilityStatus availabilityStatus,
        List<ReviewDTO> reviews,
        ReturnPolicy returnPolicy,
        Integer minimumOrderQuantity,
        MetaDTO meta,
        List<String> images,
        String thumbnail
) {}
