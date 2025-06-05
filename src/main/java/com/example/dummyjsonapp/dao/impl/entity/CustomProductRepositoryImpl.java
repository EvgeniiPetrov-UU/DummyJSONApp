package com.example.dummyjsonapp.dao.impl.entity;

import com.example.dummyjsonapp.dao.abstracts.entity.custom.CustomProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class CustomProductRepositoryImpl implements CustomProductRepository {

    @PersistenceContext
    private EntityManager entityManager;
}
