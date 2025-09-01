package com.java.identity_service.service;

import com.java.identity_service.dto.request.UserCreationRequest;
import com.java.identity_service.dto.response.UserResponse;
import com.java.identity_service.entity.User;
import com.java.identity_service.exception.AppException;
import com.java.identity_service.exception.ErrorCode;
import com.java.identity_service.mapper.UserMapper;
import com.java.identity_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true) // Make all fields private and final by default
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;

    public UserResponse createUser(UserCreationRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        User user = userMapper.toUser(request);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserEntityById(String id) {
        return userRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public UserResponse getUserById(String id) {
        return userMapper.toUserResponse(getUserEntityById(id));
    }

    public UserResponse updateUser(String userId, UserCreationRequest request) {
        User user = getUserEntityById(userId);
        userMapper.updateUserFromRequest(request, user);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    public void deleteUser(String userId) {
        User user = getUserEntityById(userId);
        userRepository.delete(user);
    }
}
