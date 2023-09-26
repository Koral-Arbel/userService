package com.firstProject.controller;

import com.firstProject.model.User;
import com.firstProject.model.UserResponse;
import com.firstProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping(value = "/user/create")
    public boolean createUser(@RequestBody UserResponse userResponse){
        return userService.createUser(userResponse);
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
    }


