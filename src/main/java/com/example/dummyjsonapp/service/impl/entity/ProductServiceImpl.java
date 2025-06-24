package com.example.dummyjsonapp.service.impl.entity;

import com.example.dummyjsonapp.dao.abstracts.entity.ProductRepository;
import com.example.dummyjsonapp.dao.converters.DimensionsMapper;
import com.example.dummyjsonapp.dao.converters.MetaMapper;
import com.example.dummyjsonapp.dao.converters.ProductMapper;
import com.example.dummyjsonapp.models.dto.product.ProductDto;
import com.example.dummyjsonapp.models.entity.AvailabilityStatus;
import com.example.dummyjsonapp.models.entity.ReturnPolicy;
import com.example.dummyjsonapp.models.entity.product.Product;
import com.example.dummyjsonapp.service.abstracts.entity.ProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final DimensionsMapper dimensionsMapper;
    private final MetaMapper metaMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,
                              ProductMapper productMapper,
                              DimensionsMapper dimensionsMapper,
                              MetaMapper metaMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.dimensionsMapper = dimensionsMapper;
        this.metaMapper = metaMapper;
    }

    @Override
    @Transactional
    public void saveProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        productRepository.save(product);
    }

    @Override
    public Product getProductByProductId(Long productId) {
        Optional<Product> existingProduct = productRepository.findById(productId);
        if (existingProduct.isEmpty()) {
            throw new EntityNotFoundException("Товара с id: " +
                    productId + " не существует");
        }
        return existingProduct.get();
    }

    @Override
    @Transactional
    public void updateProduct(ProductDto productDto) {
        Optional<Product> existingProduct = productRepository
                .findProductByTitleAndBrandAndSku(productDto.title(),
                                                  productDto.brand(),
                                                  productDto.sku());
        if (existingProduct.isEmpty()) {
            throw new EntityNotFoundException("Такого товара не существует");
        }
        existingProduct.get().setTitle(productDto.title());
        existingProduct.get().setDescription(productDto.description());
        existingProduct.get().setCategory(productDto.category());
        existingProduct.get().setPrice(productDto.price());
        existingProduct.get().setStock(productDto.stock());
        existingProduct.get()
                .setTags(productMapper.mapTagStrings(productDto.tags()));
        existingProduct.get().setBrand(productDto.brand());
        existingProduct.get().setSku(productDto.sku());
        existingProduct.get().setWeight(productDto.weight());
        existingProduct.get()
                .setDimensions(
                        dimensionsMapper.toEntity(productDto.dimensions())
                );
        existingProduct.get()
                .setWarrantyInformation(productDto.warrantyInformation());
        existingProduct.get()
                .setShippingInformation(productDto.shippingInformation());
        existingProduct.get()
                .setAvailabilityStatus(AvailabilityStatus
                        .valueOf(productDto.availabilityStatus()));
        existingProduct.get()
                .setReturnPolicy(ReturnPolicy
                        .valueOf(productDto.returnPolicy()));
        existingProduct.get()
                .setMinimumOrderQuantity(productDto.minimumOrderQuantity());
        existingProduct.get().setMeta(metaMapper.toEntity(productDto.meta()));
        existingProduct.get().setImages(productDto.images());
        existingProduct.get().setThumbnail(productDto.thumbnail());
        productRepository.save(existingProduct.get());
    }

    @Override
    public void deleteProductByProductId(Long productId) {
        if (productRepository.existsById(productId)) {
            productRepository.deleteById(productId);
        } else {
            throw new EntityNotFoundException("Товара с id: " +
                    productId + " не существует");
        }
    }

    @Override
    public boolean isExistsByProductId(Long productId) {
        return productRepository.existsById(productId);
    }
}
