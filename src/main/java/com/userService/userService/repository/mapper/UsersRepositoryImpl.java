package com.userService.userService.repository.mapper;

import org.apache.catalina.User;

public interface UsersRepositoryImpl {
    Long createUser(User user);

    void updateUserById(Long userId, User user);

    void deleteUserById(Long id);

    User getUserById(Long id);
}
