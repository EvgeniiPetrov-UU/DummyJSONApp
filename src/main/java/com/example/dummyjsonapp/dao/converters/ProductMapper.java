package com.example.dummyjsonapp.dao.converters;

import com.example.dummyjsonapp.models.dto.product.ProductDTO;
import com.example.dummyjsonapp.models.entity.product.Product;
import com.example.dummyjsonapp.models.entity.product.Tag;
import org.mapstruct.Mapper;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(
        componentModel = "spring",
        uses = {ReviewMapper.class, DimensionsMapper.class, MetaMapper.class}
)
public interface ProductMapper {

    ProductDTO toDTO(Product product);
    Product toEntity(ProductDTO productDTO);

    default Set<String> mapTags(Set<Tag> tags) {
        if (tags == null) {
            return Collections.emptySet();
        }
        return tags.stream()
                .map(Tag::getName)
                .collect(Collectors.toSet());
    }

    default Set<Tag> mapTagStrings(Set<String> tagsNames) {
        if (tagsNames == null) {
            return Collections.emptySet();
        }
        return tagsNames.stream()
                .map(name -> {
                    Tag tag = new Tag();
                    tag.setName(name);
                    return tag;
                })
                .collect(Collectors.toSet());
    }
}
