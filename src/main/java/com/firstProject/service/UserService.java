package com.firstProject.service;

import com.firstProject.model.User;
import com.firstProject.model.UserResponse;

import java.util.List;

public interface UserService {

    void createUser(UserResponse userResponse);

    User updateUser(Long userId, User user);

    void deleteUserById(Long id);
    User getUserById(Long id);
    List<User> getUsers();
    List<User> getAllUsersByFirstName(String firstName);
    User getUserByEmail(String email);

}
