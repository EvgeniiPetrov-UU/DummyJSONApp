package com.example.dummyjsonapp.service.impl.dto;

import com.example.dummyjsonapp.dao.abstracts.entity.UserRepository;
import com.example.dummyjsonapp.dao.converters.UserMapper;
import com.example.dummyjsonapp.models.dto.user.UserDto;
import com.example.dummyjsonapp.models.entity.user.User;
import com.example.dummyjsonapp.service.abstracts.dto.UserDtoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserDtoServiceImpl implements UserDtoService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDtoServiceImpl(UserRepository userRepository,
                              UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto getUserDtoByUserId(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new EntityNotFoundException("Пользователя с id: "
                    + userId + " не существует.");
        }
        return userMapper.toDTO(user.get());
    }
}
