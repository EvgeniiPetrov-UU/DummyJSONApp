package com.example.dummyjsonapp.dao.converters;

import com.example.dummyjsonapp.models.dto.user.UserDto;
import com.example.dummyjsonapp.models.entity.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ReviewMapper.class})
public interface UserMapper {

    @Mapping(target = "name",
            expression = "java(mapUserNameAndSurnameToUserDtoName(user))")
    UserDto toDTO(User user);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    @Mapping(target = "name",
            expression = "java(mapUserDtoNameToUserName(userDto))")
    @Mapping(target = "surname",
            expression = "java(mapUserDtoNameToUserSurname(userDto))")
    User toEntity(UserDto userDto);

    default String mapUserNameAndSurnameToUserDtoName(User user) {
        return user.getName() + " " + user.getSurname();
    }

    default String mapUserDtoNameToUserName(UserDto userDto) {
        return userDto.name().substring(0, userDto.name().indexOf(' '));
    }

    default String mapUserDtoNameToUserSurname(UserDto userDto) {
        return userDto.name().substring(userDto.name().indexOf(' ') + 1);
    }
}
