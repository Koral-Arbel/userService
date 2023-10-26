package com.firstProject.service;

import com.firstProject.model.User;
import com.firstProject.model.UserResponse;
import com.firstProject.pollService.PollServiceClient;
import com.firstProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PollServiceClient pollServiceClient;


    @Override
    public void createUser(UserResponse userResponse) {
        String email = userResponse.getEmail();

        // Check if the email is already registered
        if (userRepository.getUserByEmail(email) != null) {
            // Handle the case where the email is already registered
            // You can throw a more specific exception or return an error response here
            throw new IllegalArgumentException("Email is already registered.");
        }

        User user = new User(
                null,
                userResponse.getFirstName(),
                userResponse.getLastName(),
                email,
                userResponse.getAge(),
                userResponse.getAddress(),
                userResponse.getJoiningDate(),
                true
        );
        userRepository.createUser(user, userResponse);
    }

    @Override
    public User updateUser(Long userId, User user) {
        User existingUser = userRepository.getUserById(userId);
        if (existingUser != null) {
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            existingUser.setAge(user.getAge());
            existingUser.setAddress(user.getAddress());
            existingUser.setJoiningDate(user.getJoiningDate());
            existingUser.setRegistered(user.isRegistered());
            userRepository.updateUser(existingUser);
            return existingUser;
        } else {
            throw new IllegalArgumentException("User not found.");
        }
    }

    @Override
    public void deleteUserAnswerById(Long userId) {
        pollServiceClient.deleteUserAnswerById(userId);
        userRepository.deleteUserAnswerById(userId);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.getUserById(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    @Override
    public List<User> getAllUsersByFirstName(String firstName) {
        return userRepository.getUsersByFirstName(firstName);
    }

    @Override
    public Boolean isRegistered(Long userId) {
        User user = getUserById(userId);
        if (user != null && user.isRegistered()) {
            return true;
        } else {
            return false;
        }
    }
}