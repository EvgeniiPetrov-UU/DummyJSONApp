package com.example.dummyjsonapp.dao.converters;

import com.example.dummyjsonapp.models.dto.product.MetaDto;
import com.example.dummyjsonapp.models.entity.product.Meta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MetaMapper {

    MetaDto toDTO(Meta meta);
    @Mapping(target = "id", ignore = true)
    Meta toEntity(MetaDto metaDto);
}
