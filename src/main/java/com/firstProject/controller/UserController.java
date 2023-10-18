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

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    PollServiceClient pollServiceClient;

    @PostMapping(value = "/user/create")
    @CrossOrigin
    public ResponseEntity<String> createUser(@RequestBody UserResponse userResponse) {
        if (!userService.userExists(userResponse.getEmail())) {
            userService.createUser(userResponse);
            return ResponseEntity.status(HttpStatus.OK).body("User registered successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists.");
        }
    }

    @PutMapping(value = "/user/{userId}/update")
        public void updateUser (@PathVariable Long userId, @RequestBody User user){
            userService.updateUser(user);
    }

    @DeleteMapping(value = "/user/{userId}/delete")
        public void deleteUser (@PathVariable Long userId){
            userService.deleteUserById(userId);
        }
        @GetMapping(value = "/user/{userId}")
        public User getUserById (@PathVariable Long userId){
            return userService.getUserById(userId);
        }


        @GetMapping(value = "/usersList")
        public List<User> getUsersByFirstName (@RequestParam String firstName){
            return userService.getAllUsersByFirstName(firstName);
        }

        @GetMapping(value = "/checkUserByEmail/{email}")
        public ResponseEntity<String> checkEmail (@PathVariable String email) {
            if (userService.userExists(email)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exists");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body("Email does not exist");
            }
        }
}


