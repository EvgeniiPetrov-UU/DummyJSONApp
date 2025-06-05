package com.example.dummyjsonapp.dao.abstracts.entity;

import com.example.dummyjsonapp.models.entity.product.Meta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetaRepository extends JpaRepository<Meta, Long> {
}
