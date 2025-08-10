package com.java.identity_service.controller;

import com.java.identity_service.dto.request.ApiResponse;
import com.java.identity_service.dto.request.UserCreationRequest;
import com.java.identity_service.entity.User;
import com.java.identity_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    User createUser(@RequestBody @Valid UserCreationRequest request) {
        return userService.createUser(request);
    }

    @GetMapping("/{userId}")
    User getUserById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("/{userId}")
    ApiResponse<User> updateUser(@PathVariable String userId, @RequestBody UserCreationRequest request){
        ApiResponse<User> response = new ApiResponse<User>();

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
