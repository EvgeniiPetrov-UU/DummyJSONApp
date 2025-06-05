package com.example.dummyjsonapp.dao.converters;

import com.example.dummyjsonapp.models.dto.user.UserDto;
import com.example.dummyjsonapp.models.entity.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ReviewMapper.class})
public interface UserMapper {

    UserDto toDTO(User user);
    User toEntity(UserDto userDTO);
}
