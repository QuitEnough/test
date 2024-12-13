package ru.tasktracler.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.tasktracler.userservice.domain.dto.UserCreateRequest;
import ru.tasktracler.userservice.domain.dto.UserResponse;
import ru.tasktracler.userservice.domain.entity.User;
import ru.tasktracler.userservice.domain.mapper.UserMapper;
import ru.tasktracler.userservice.exception.UserNotFoundException;
import ru.tasktracler.userservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final PasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.encoder = encoder;
    }

    @Override
    public void addUser(UserCreateRequest userRequest) {
        if (userRepository.existsByEmail(userRequest.getEmail())) {
            throw new IllegalStateException("User already exists.");
        }
        if (!userRequest.getPassword().equals(userRequest.getPasswordConfirmation())) {
            throw new IllegalStateException("Password and password confirmation do not match.");
        }
        User user = userMapper.toUser(userRequest);
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public UserResponse getUserById(Long userId) {
        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with given id not found."));
        return userMapper.toUserResponse(user);
    }

    @Override
    public UserResponse getUserByEmail(String email) {
        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User with given email not found."));
        return userMapper.toUserResponse(user);
    }

}
