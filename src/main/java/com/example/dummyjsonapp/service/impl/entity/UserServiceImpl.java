package com.example.dummyjsonapp.service.impl.entity;

import com.example.dummyjsonapp.dao.abstracts.entity.UserRepository;
import com.example.dummyjsonapp.dao.converters.UserMapper;
import com.example.dummyjsonapp.models.dto.user.UserDto;
import com.example.dummyjsonapp.models.entity.user.User;
import com.example.dummyjsonapp.service.abstracts.entity.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public void saveUser(UserDto userDto) {
        userRepository.save(userMapper.toEntity(userDto));
    }

    @Override
    public User getUserByUserId(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new EntityNotFoundException("Пользователя с id: "
                    + userId + " не существует.");
        }
        return user.get();
    }

    @Override
    @Transactional
    public void updateUser(UserDto userDto) {
        Optional<User> existingUser = userRepository.findByEmail(userDto.email());
        if (existingUser.isEmpty()) {
            throw new EntityNotFoundException("Пользователя с email: "
                    + userDto.email() + " не существует.");
        }
        String userName = userDto.name()
                .substring(0, userDto.name().indexOf(" "));
        String userSurname = userDto.name()
                .substring(userDto.name().indexOf(" ") + 1);
        existingUser.get().setEmail(userDto.email());
        existingUser.get().setName(userName);
        existingUser.get().setSurname(userSurname);
        userRepository.save(existingUser.get());
    }

    @Override
    public void deleteUserByUserId(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new EntityNotFoundException("Пользователь с id: "
                    + userId + " не существует");
        }
        userRepository.deleteById(userId);
    }
}
