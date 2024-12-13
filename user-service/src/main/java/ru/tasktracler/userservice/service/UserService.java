package ru.tasktracler.userservice.service;

import ru.tasktracler.userservice.domain.dto.UserCreateRequest;
import ru.tasktracler.userservice.domain.dto.UserResponse;

public interface UserService {

    void addUser(UserCreateRequest userRequest);

    UserResponse getUserById(Long userId);

    UserResponse getUserByEmail(String email);

}
