package com.example.dummyjsonapp.service.abstracts.entity;

import com.example.dummyjsonapp.models.dto.product.DimensionsDto;
import com.example.dummyjsonapp.models.entity.product.Dimensions;

public interface DimensionsService {

    Dimensions getDimensionsForProductByProductId(Long productId);
    void updateDimensionsForProductByProductId(Long productId,
                                               DimensionsDto dimensionsDto);
}
