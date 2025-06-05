package com.example.dummyjsonapp.dao.converters;

import com.example.dummyjsonapp.models.dto.product.DimensionsDto;
import com.example.dummyjsonapp.models.entity.product.Dimensions;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DimensionsMapper {

    DimensionsDto toDTO(Dimensions dimensions);
    Dimensions toEntity(DimensionsDto dimensionsDTO);
}
