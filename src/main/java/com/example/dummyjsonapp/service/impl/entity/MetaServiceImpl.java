package com.example.dummyjsonapp.service.impl.entity;

import com.example.dummyjsonapp.dao.abstracts.entity.MetaRepository;
import com.example.dummyjsonapp.models.entity.product.Meta;
import com.example.dummyjsonapp.service.abstracts.entity.MetaService;
import com.example.dummyjsonapp.service.abstracts.entity.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MetaServiceImpl implements MetaService {

    private final MetaRepository metaRepository;
    private final ProductService productService;

    @Autowired
    public MetaServiceImpl(MetaRepository metaRepository,
                           ProductService productService) {
        this.metaRepository = metaRepository;
        this.productService = productService;
    }

    //Этому методу не нужна проверка на null, ведь она уже проведена в методе getProductById()
    @Override
    public Meta getMetaDataForProductByProductId(Long productId) {
        return productService.getProductByProductId(productId).getMeta();
    }
}
