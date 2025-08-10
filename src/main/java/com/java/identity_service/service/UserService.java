package com.java.identity_service.service;

import com.java.identity_service.dto.request.UserCreationRequest;
import com.java.identity_service.entity.User;
import com.java.identity_service.exception.AppException;
import com.java.identity_service.exception.ErrorCode;
import com.java.identity_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreationRequest request) {
        User user = new User();

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(UUID.fromString(id)).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public User updateUser(String userId, UserCreationRequest request) {
        User user = getUserById(userId);

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    public void deleteUser(String userId) {
        User user = getUserById(userId);
        userRepository.delete(user);
    }
}
