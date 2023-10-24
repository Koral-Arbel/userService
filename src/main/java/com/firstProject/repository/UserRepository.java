package com.firstProject.repository;

import com.firstProject.model.User;
import com.firstProject.model.UserResponse;

import java.util.List;

public interface UserRepository {

    User createUser(User user, UserResponse userResponse);

    User updateUser(User user);

    void deleteUser(Long id);

    User getUserById(Long id);

    User getUserByEmail(String email);

    List<User> getUsers();

    List<User> getUsersByFirstName(String firstName);
}
