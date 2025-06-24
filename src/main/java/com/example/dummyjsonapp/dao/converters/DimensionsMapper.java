package com.example.dummyjsonapp.dao.converters;

import com.example.dummyjsonapp.models.dto.product.DimensionsDto;
import com.example.dummyjsonapp.models.entity.product.Dimensions;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DimensionsMapper {

    DimensionsDto toDTO(Dimensions dimensions);
    @Mapping(target = "id", ignore = true)
    Dimensions toEntity(DimensionsDto dimensionsDto);
}
