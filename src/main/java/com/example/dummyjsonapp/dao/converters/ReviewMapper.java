package com.example.dummyjsonapp.dao.converters;

import com.example.dummyjsonapp.models.dto.product.ReviewDto;
import com.example.dummyjsonapp.models.entity.product.Review;
import com.example.dummyjsonapp.models.entity.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    ReviewDto toDTO(Review review);
    Review toEntity(ReviewDto reviewDTO);

    default String mapUserToReviewerName(User user) {
        return user != null ? user.getName() + " " + user.getSurname() : null;
    }

    default String mapUserToReviewerEmail(User user) {
        return user != null ? user.getEmail() : null;
    }
}
