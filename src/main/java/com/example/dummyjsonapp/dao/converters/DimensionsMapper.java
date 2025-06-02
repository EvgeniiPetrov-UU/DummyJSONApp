package com.example.dummyjsonapp.dao.converters;

import com.example.dummyjsonapp.models.dto.product.DimensionsDTO;
import com.example.dummyjsonapp.models.entity.product.Dimensions;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DimensionsMapper {

    DimensionsDTO toDTO(Dimensions dimensions);
    Dimensions toEntity(DimensionsDTO dimensionsDTO);
}
