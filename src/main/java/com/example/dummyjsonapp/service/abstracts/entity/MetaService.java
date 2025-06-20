package com.example.dummyjsonapp.service.abstracts.entity;

import com.example.dummyjsonapp.models.entity.product.Meta;

public interface MetaService {

    Meta getMetaDataForProductByProductId(Long productId);
}
