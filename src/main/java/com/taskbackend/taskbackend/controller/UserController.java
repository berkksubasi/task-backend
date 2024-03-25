package com.taskbackend.taskbackend.controller;

import com.taskbackend.taskbackend.model.User;
import com.taskbackend.taskbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // User Registration
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        validatePassword(user);
        System.out.println("Registering User: " + user.getUsername());
        return userService.registerUser(user);
    }

    private void validatePassword(User user) {
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            throw new IllegalArgumentException("Password Not Matching");
        }
    }

    // User Login
    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User user) {
        User loggedInUser = userService.loginUser(user.getUsername(), user.getPassword());
        if (loggedInUser != null) {
            // Login Success
            System.out.println("Login Success: " + loggedInUser.getUsername());
            return ResponseEntity.ok(loggedInUser);
        } else {
            // Login Failed
            System.out.println("Login failed: " + user.getUsername());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    // Get User Information
    @GetMapping("/{userId}")
    public User getUserDetails(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }
}
