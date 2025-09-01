package com.java.identity_service.mapper;

import com.java.identity_service.dto.request.UserCreationRequest;
import com.java.identity_service.dto.response.UserResponse;
import com.java.identity_service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    UserResponse toUserResponse(User user);
    void updateUserFromRequest(UserCreationRequest request, @MappingTarget User user);
}
