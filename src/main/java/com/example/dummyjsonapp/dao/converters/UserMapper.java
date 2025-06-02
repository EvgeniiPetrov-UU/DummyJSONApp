package com.example.dummyjsonapp.dao.converters;

import com.example.dummyjsonapp.models.dto.user.UserDTO;
import com.example.dummyjsonapp.models.entity.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ReviewMapper.class})
public interface UserMapper {

    UserDTO toDTO(User user);
    User toEntity(UserDTO userDTO);
}
