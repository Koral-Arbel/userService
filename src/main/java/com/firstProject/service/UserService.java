package com.firstProject.service;

import com.firstProject.model.User;
import com.firstProject.model.UserResponse;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User updateUser(User user);

    void deleteUserById(Long id);
    User getUserById(Long id);
    List<User> getUsers();
    List<User> getAllUsersByFirstName(String firstName);

    boolean isUserRegistered(String email);
}
