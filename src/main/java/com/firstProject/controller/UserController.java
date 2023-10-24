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

    @DeleteMapping("/{userId}/delete")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully.");

    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("")
    public ResponseEntity<User> getUserByEmail(@RequestParam String email) {
        User user = userService.getUserByEmail(email);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/usersList")
    public List<User> getUsersByFirstName(@RequestParam String firstName) {
        return userService.getAllUsersByFirstName(firstName);
    }

}