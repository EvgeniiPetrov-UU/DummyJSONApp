package com.example.dummyjsonapp.dao.converters;

import com.example.dummyjsonapp.models.dto.product.MetaDTO;
import com.example.dummyjsonapp.models.entity.product.Meta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MetaMapper {

    MetaDTO toDTO(Meta meta);
    Meta toEntity(MetaDTO metaDTO);
}
