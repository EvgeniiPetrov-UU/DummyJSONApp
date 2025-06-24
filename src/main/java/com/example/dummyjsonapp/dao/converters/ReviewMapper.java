package com.example.dummyjsonapp.dao.converters;

import com.example.dummyjsonapp.models.dto.product.ReviewDto;
import com.example.dummyjsonapp.models.entity.product.Review;
import com.example.dummyjsonapp.models.entity.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    @Mapping(target="reviewerName",
            expression = "java(mapUserToReviewerName(review.getReviewer()))")
    @Mapping(target = "reviewerEmail",
            expression = "java(mapUserToReviewerEmail(review.getReviewer()))")
    ReviewDto toDTO(Review review);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "product", ignore = true)
    Review toEntity(ReviewDto reviewDto);

    default String mapUserToReviewerName(User user) {
        return user != null ? user.getName() + " " + user.getSurname() : null;
    }

    default String mapUserToReviewerEmail(User user) {
        return user != null ? user.getEmail() : null;
    }
}
