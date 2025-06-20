package com.example.dummyjsonapp.dao.abstracts.entity;

import com.example.dummyjsonapp.dao.abstracts.entity.custom.CustomUserRepository;
import com.example.dummyjsonapp.models.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository
        extends JpaRepository<User, Long>, CustomUserRepository {

    Optional<User> findByEmail(String email);
}
