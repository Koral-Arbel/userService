package com.firstProject.service;

import com.firstProject.model.User;
import com.firstProject.model.UserResponse;
import com.firstProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;


    @Override
    public User createUser(User user) {
        user.setRegistered(true);
        return userRepository.createUser(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.updateUser(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteUser(id);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public List<User> getAllUsersByFirstName(String firstName) {
        return userRepository.getUsersByFirstName(firstName);
    }


    @Override
    public boolean isUserRegistered(String email) {
        Boolean user = userRepository.existsByEmail(email);
        return user != null && user.booleanValue();
    }

}
