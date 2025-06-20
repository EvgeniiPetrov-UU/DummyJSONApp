package com.example.dummyjsonapp.service.abstracts.dto;

import com.example.dummyjsonapp.models.dto.user.UserDto;

public interface UserDtoService {

    UserDto getUserDtoByUserId(Long userId);
}
