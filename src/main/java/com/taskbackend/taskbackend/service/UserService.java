package com.taskbackend.taskbackend.service;

import com.taskbackend.taskbackend.model.User;
import com.taskbackend.taskbackend.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return null;
        }
        return userRepository.save(user);
    }

    public User loginUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

}
