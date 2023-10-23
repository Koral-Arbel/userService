package com.firstProject.controller;

import com.firstProject.model.User;
import com.firstProject.model.UserResponse;
import com.firstProject.pollService.PollServiceClient;
import com.firstProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "user")
@CrossOrigin(origins = "*")

@RestController
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    PollServiceClient pollServiceClient;

    @PostMapping(value = "/create")
    public ResponseEntity<String> createUser(@RequestBody UserResponse userResponse) {
        if (!userService.isEmailRegistered(userResponse.getEmail())) {
            userService.createUser(userResponse);
            return ResponseEntity.status(HttpStatus.OK).body("User registered successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists.");
        }
    }

    @PostMapping(value = "/register")
    public ResponseEntity<String> registerUser(@RequestParam UserResponse userResponse) {
        if (!userService.isEmailRegistered(userResponse.getEmail())) {
            userService.createUser(userResponse);
            return ResponseEntity.ok("User registered successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists.");
        }
    }

    @PutMapping(value = "/{userId}/update")
    public void updateUser(@PathVariable Long userId, @RequestBody User user) {
        userService.updateUser(user);
    }

    @DeleteMapping(value = "/{userId}/delete")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUserById(userId);
        pollServiceClient.deleteUserAnswerById(userId);
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "")
    public ResponseEntity<User> getUserByEmail(@RequestParam String email) {
        User user = userService.getUserByEmail(email);
        if (email != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/usersList")
    public List<User> getUsersByFirstName(@RequestParam String firstName) {
        return userService.getAllUsersByFirstName(firstName);
    }
}