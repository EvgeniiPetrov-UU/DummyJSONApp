package com.example.dummyjsonapp.dao.abstracts.entity;

import com.example.dummyjsonapp.dao.abstracts.entity.custom.CustomProductRepository;
import com.example.dummyjsonapp.models.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository
        extends JpaRepository<Product, Long>, CustomProductRepository {

    Optional<Product> findProductByTitleAndBrandAndSku(String title, String brand,
                                                       String sku);
}
