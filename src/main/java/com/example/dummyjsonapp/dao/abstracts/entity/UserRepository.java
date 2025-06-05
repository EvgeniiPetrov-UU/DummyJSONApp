package com.example.dummyjsonapp.dao.abstracts.entity;

import com.example.dummyjsonapp.dao.abstracts.entity.custom.CustomUserRepository;
import com.example.dummyjsonapp.models.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
        extends JpaRepository<User, Long>, CustomUserRepository {
}
