package com.example.dummyjsonapp.dao.impl.entity;

import com.example.dummyjsonapp.dao.abstracts.entity.custom.CustomReviewRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class CustomReviewRepositoryImpl implements CustomReviewRepository {

    @PersistenceContext
    private EntityManager entityManager;
}
