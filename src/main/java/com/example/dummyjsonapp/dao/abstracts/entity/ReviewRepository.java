package com.example.dummyjsonapp.dao.abstracts.entity;

import com.example.dummyjsonapp.dao.abstracts.entity.custom.CustomReviewRepository;
import com.example.dummyjsonapp.models.entity.product.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.Optional;

public interface ReviewRepository
        extends JpaRepository<Review, Long>, CustomReviewRepository {

    Optional<Review> findByReviewerEmailAndDate(String reviewerEmail, Instant date);
}
