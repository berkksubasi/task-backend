package com.taskbackend.taskbackend.controller;

import com.taskbackend.taskbackend.model.User;
import com.taskbackend.taskbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // User Registration
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        // Parola doğrulamasını kontrol et
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            throw new IllegalArgumentException("Password Not Matching");
        }
        return userService.registerUser(user);
    }

    // User Login
    @PostMapping("/login")
    public User loginUser(@RequestBody User user) {
        return userService.loginUser(user.getUsername(), user.getPassword());
    }

    // Get User Information
    @GetMapping("/{userId}")
    public User getUserDetails(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }
}
