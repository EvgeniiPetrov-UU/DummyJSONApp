package com.example.dummyjsonapp.service.impl.entity;

import com.example.dummyjsonapp.dao.abstracts.entity.ReviewRepository;
import com.example.dummyjsonapp.dao.converters.ReviewMapper;
import com.example.dummyjsonapp.models.dto.product.ReviewDto;
import com.example.dummyjsonapp.models.entity.product.Review;
import com.example.dummyjsonapp.service.abstracts.entity.ReviewService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository,
                             ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
    }

    @Override
    @Transactional
    public void saveReview(ReviewDto reviewDto) {
        reviewRepository.save(reviewMapper.toEntity(reviewDto));
    }

    @Override
    public Review getReviewByReviewId(Long reviewId) {
        Optional<Review> review = reviewRepository.findById(reviewId);
        if (review.isEmpty()) {
            throw new EntityNotFoundException("Отзыва с id: "
                    + reviewId + " не существует");
        }
        return review.get();
    }

    @Override
    @Transactional
    public void updateReview(ReviewDto reviewDto) {
        Optional<Review> existingReview = reviewRepository
                .findByReviewerEmailAndDate(
                        reviewDto.reviewerEmail(),
                        reviewDto.date()
                );
        if (existingReview.isEmpty()) {
            throw new EntityNotFoundException("Пользователь с email: "
                    + reviewDto.reviewerEmail() + " не оставлял такого отзыва");
        }
        existingReview.get().setRating(reviewDto.rating());
        existingReview.get().setComment(reviewDto.comment());
        reviewRepository.save(existingReview.get());
    }

    @Override
    public void deleteReviewByReviewId(Long reviewId) {
        if (!reviewRepository.existsById(reviewId)) {
            throw new EntityNotFoundException("Отзыва с id: "
                    + reviewId + " не существует");
        }
        reviewRepository.deleteById(reviewId);
    }
}
