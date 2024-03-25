package com.taskbackend.taskbackend.repository;

import com.taskbackend.taskbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);



}