package ru.tasktracler.userservice.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import ru.tasktracler.userservice.domain.dto.UserCreateRequest;
import ru.tasktracler.userservice.domain.dto.UserResponse;
import ru.tasktracler.userservice.domain.entity.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    UserResponse toUserResponse(User user);

    UserCreateRequest toUserRequest(User user);

    User toUser(UserCreateRequest userRequest);

}
