package com.java.identity_service.controller;

import com.java.identity_service.dto.request.ApiResponse;
import com.java.identity_service.dto.request.UserCreationRequest;
import com.java.identity_service.dto.response.UserResponse;
import com.java.identity_service.entity.User;
import com.java.identity_service.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;

    @GetMapping
    List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    UserResponse createUser(@RequestBody @Valid UserCreationRequest request) {
        return userService.createUser(request);
    }

    @GetMapping("/{userId}")
    UserResponse getUserById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("/{userId}")
    ApiResponse<UserResponse> updateUser(@PathVariable String userId, @RequestBody UserCreationRequest request){
        ApiResponse<UserResponse> response = new ApiResponse<UserResponse>();

        response.setResult(userService.updateUser(userId, request));
        response.setMessage("User updated successfully.");

        return response;
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "User with id " + userId + " deleted successfully.";
    }
}
