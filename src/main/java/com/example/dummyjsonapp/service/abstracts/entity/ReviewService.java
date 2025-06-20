package com.example.dummyjsonapp.service.abstracts.entity;

import com.example.dummyjsonapp.models.dto.product.ReviewDto;
import com.example.dummyjsonapp.models.entity.product.Review;

public interface ReviewService {

    void saveReview(ReviewDto reviewDto);
    Review getReviewByReviewId(Long reviewId);
    void updateReview(ReviewDto reviewDto);
    void deleteReviewByReviewId(Long reviewId);
}
