package com.example.dummyjsonapp.service.abstracts.entity;

import com.example.dummyjsonapp.models.dto.user.UserDto;
import com.example.dummyjsonapp.models.entity.user.User;

public interface UserService {

    void saveUser(UserDto userDto);
    User getUserByUserId(Long userId);
    void updateUser(UserDto userDto);
    void deleteUserByUserId(Long userId);
}
