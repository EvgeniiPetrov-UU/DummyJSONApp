package com.example.dummyjsonapp.dao.impl.entity;

import com.example.dummyjsonapp.dao.abstracts.entity.custom.CustomUserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class CustomUserRepositoryImpl implements CustomUserRepository {

    @PersistenceContext
    private EntityManager entityManager;
}
