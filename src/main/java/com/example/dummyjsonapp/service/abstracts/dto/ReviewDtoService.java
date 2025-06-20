package com.example.dummyjsonapp.service.abstracts.dto;

import com.example.dummyjsonapp.models.dto.product.ReviewDto;

public interface ReviewDtoService {

    ReviewDto getReviewDtoByReviewId(Long reviewId);
}
