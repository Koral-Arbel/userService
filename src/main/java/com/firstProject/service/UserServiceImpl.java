package com.firstProject.service;

import com.firstProject.model.User;
import com.firstProject.model.UserResponse;
import com.firstProject.pollService.PollService;
import com.firstProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PollService pollService;


    @Override
    public boolean createUser(UserResponse userResponse) {
        String email = userResponse.getEmail();

        // Check if the email is already registered
        boolean isEmailRegistered = userRepository.getUserByEmail(email) != null;
        if (isEmailRegistered) {
            // Handle the case where the email is already registered
            // You can throw an exception or return an error response here
            // For simplicity, let's assume an exception is thrown
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

        user = userRepository.createUser(userResponse);

        return new UserResponse(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getAge(),
                user.getAddress(),
                userResponse.getJoiningDate(),
                userResponse.isRegistered()).isRegistered();
    }



    @Override
    public User updateUser(User user) {
        return userRepository.updateUser(user);
    }

    @Override
    public void deleteUserById(Long id) {
        pollService.deleteAnswersByUserId(id);
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
}