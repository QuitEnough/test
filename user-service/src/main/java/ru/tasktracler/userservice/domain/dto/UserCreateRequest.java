package ru.tasktracler.userservice.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserCreateRequest {

    private String email;

    private String password;

    private String passwordConfirmation;

}
