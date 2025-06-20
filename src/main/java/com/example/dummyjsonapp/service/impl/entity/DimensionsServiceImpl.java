package com.example.dummyjsonapp.service.impl.entity;

import com.example.dummyjsonapp.dao.abstracts.entity.DimensionsRepository;
import com.example.dummyjsonapp.dao.converters.DimensionsMapper;
import com.example.dummyjsonapp.dao.converters.ProductMapper;
import com.example.dummyjsonapp.models.dto.product.DimensionsDto;
import com.example.dummyjsonapp.models.entity.product.Dimensions;
import com.example.dummyjsonapp.service.abstracts.entity.DimensionsService;
import com.example.dummyjsonapp.service.abstracts.entity.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class DimensionsServiceImpl implements DimensionsService {

    private final DimensionsRepository dimensionsRepository;
    private final DimensionsMapper dimensionsMapper;
    private final ProductService productService;
    private final ProductMapper productMapper;

    @Autowired
    public DimensionsServiceImpl(DimensionsRepository dimensionsRepository,
                                 DimensionsMapper dimensionsMapper,
                                 ProductService productService,
                                 ProductMapper productMapper) {
        this.dimensionsRepository = dimensionsRepository;
        this.dimensionsMapper = dimensionsMapper;
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @Override
    public Dimensions getDimensionsForProductByProductId(Long productId) {
        return productService.getProductByProductId(productId).getDimensions();
    }

    @Override
    @Transactional
    public void updateDimensionsForProductByProductId(Long productId,
                                                      DimensionsDto dimensionsDto) {
        Dimensions existingDimensions = productService
                .getProductByProductId(productId)
                .getDimensions();
        existingDimensions.setDepth(dimensionsDto.depth());
        existingDimensions.setHeight(dimensionsDto.height());
        existingDimensions.setWidth(dimensionsDto.width());
        dimensionsRepository.save(existingDimensions);
    }
}
