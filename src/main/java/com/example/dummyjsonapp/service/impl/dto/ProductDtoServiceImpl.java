package com.example.dummyjsonapp.service.impl.dto;

import com.example.dummyjsonapp.dao.abstracts.entity.ProductRepository;
import com.example.dummyjsonapp.dao.converters.ProductMapper;
import com.example.dummyjsonapp.models.dto.product.ProductDto;
import com.example.dummyjsonapp.models.entity.product.Product;
import com.example.dummyjsonapp.service.abstracts.dto.ProductDtoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProductDtoServiceImpl implements ProductDtoService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductDtoServiceImpl(ProductRepository productRepository,
                                 ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDto getProductDtoByProductId(Long productId) {
        Optional<Product> existingProduct = productRepository.findById(productId);
        if (existingProduct.isEmpty()) {
            throw new EntityNotFoundException("Товара с id: " +
                    productId + " не существует");
        }
        return productMapper.toDTO(existingProduct.get());
    }
}
