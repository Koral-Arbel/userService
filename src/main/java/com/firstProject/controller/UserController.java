package com.firstProject.controller;
import com.firstProject.model.User;
import com.firstProject.model.UserResponse;
import com.firstProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/user")
@CrossOrigin(origins = "*")

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UserResponse userResponse) {
        try {
            userService.createUser(userResponse);
            return ResponseEntity.status(HttpStatus.OK).body("User registered successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{userId}/update")
    public ResponseEntity<String> updateUser(@PathVariable Long userId, @RequestBody User user) {
        userService.updateUser(userId, user);
        return ResponseEntity.status(HttpStatus.OK).body("User updated successfully.");
    }

    @DeleteMapping("/userAnswer/deleteUser/{userId}")
    public void deleteUserAnswerById(@PathVariable Long userId) {
        userService.deleteUserAnswerById(userId);
    }


    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getUserByEmail/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/getUserByFirstName")
    public List<User> getUsersByFirstName(@RequestParam String firstName) {
        return userService.getAllUsersByFirstName(firstName);
    }

    @GetMapping("/isRegistered/{userId}")
    public ResponseEntity<Boolean> isRegistered(@PathVariable Long userId) {
        boolean registered = userService.isRegistered(userId);
        return ResponseEntity.ok(registered);
    }
}