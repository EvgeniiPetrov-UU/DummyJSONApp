package com.example.dummyjsonapp.service.impl.dto;

import com.example.dummyjsonapp.dao.abstracts.entity.ReviewRepository;
import com.example.dummyjsonapp.dao.converters.ReviewMapper;
import com.example.dummyjsonapp.models.dto.product.ReviewDto;
import com.example.dummyjsonapp.models.entity.product.Review;
import com.example.dummyjsonapp.service.abstracts.dto.ReviewDtoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ReviewDtoServiceImpl implements ReviewDtoService {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    public ReviewDtoServiceImpl(ReviewRepository reviewRepository,
                                ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
    }

    @Override
    public ReviewDto getReviewDtoByReviewId(Long reviewId) {
        Optional<Review> review = reviewRepository.findById(reviewId);
        if (review.isEmpty()) {
            throw new EntityNotFoundException("Отзыва с id: "
                    + reviewId + " не существует");
        }
        return reviewMapper.toDTO(review.get());
    }
}
