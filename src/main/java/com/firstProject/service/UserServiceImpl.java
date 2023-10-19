package com.firstProject.service;

import com.firstProject.model.User;
import com.firstProject.model.UserResponse;
import com.firstProject.pollService.PollServiceClient;
import com.firstProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                userResponse.getJoiningDate()
        );

        userRepository.createUser(user, userResponse);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.updateUser(user);
    }

    @Override
    public void deleteUserById(Long id) {
        pollServiceClient.deleteUserAnswerById(id);
        userRepository.deleteUser(id);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
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
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public boolean isEmailRegistered(String email) {
        return userRepository.isEmailRegistered(email);
    }

}