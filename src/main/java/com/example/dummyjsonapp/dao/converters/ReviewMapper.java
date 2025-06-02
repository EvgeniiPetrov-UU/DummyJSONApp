package com.example.dummyjsonapp.dao.converters;

import com.example.dummyjsonapp.models.dto.product.ReviewDTO;
import com.example.dummyjsonapp.models.entity.product.Review;
import com.example.dummyjsonapp.models.entity.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    ReviewDTO toDTO(Review review);
    Review toEntity(ReviewDTO reviewDTO);

    default String mapUserToReviewerName(User user) {
        return user != null ? user.getName() + " " + user.getSurname() : null;
    }

    default String mapUserToReviewerEmail(User user) {
        return user != null ? user.getEmail() : null;
    }
}
