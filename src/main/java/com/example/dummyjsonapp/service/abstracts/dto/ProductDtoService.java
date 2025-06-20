package com.example.dummyjsonapp.service.abstracts.dto;

import com.example.dummyjsonapp.models.dto.product.ProductDto;

public interface ProductDtoService {

    ProductDto getProductDtoByProductId(Long productId);
}
