package com.example.dummyjsonapp.service.abstracts.entity;

import com.example.dummyjsonapp.models.dto.product.ProductDto;
import com.example.dummyjsonapp.models.entity.product.Product;

public interface ProductService {

    void saveProduct(ProductDto productDto);
    Product getProductByProductId(Long productId);
    void updateProduct(ProductDto productDto);
    void deleteProductByProductId(Long productId);
    boolean isExistsByProductId(Long productId);
}
