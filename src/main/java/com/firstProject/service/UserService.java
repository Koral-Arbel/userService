package com.firstProject.service;

import com.firstProject.model.User;
import com.firstProject.model.UserResponse;

import java.util.List;

public interface UserService {

    boolean createUser(UserResponse userResponse);

    User updateUser(User user);

    void deleteUserById(Long id);
    User getUserById(Long id);
    List<User> getUsers();
    List<User> getAllUsersByFirstName(String firstName);
    User getUserByEmail(String email);
    boolean isEmailRegistered(String email);

}
