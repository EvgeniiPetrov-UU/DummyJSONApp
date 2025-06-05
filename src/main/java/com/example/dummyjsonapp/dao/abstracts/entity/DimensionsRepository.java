package com.example.dummyjsonapp.dao.abstracts.entity;

import com.example.dummyjsonapp.models.entity.product.Dimensions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DimensionsRepository extends JpaRepository<Dimensions, Long> {
}
