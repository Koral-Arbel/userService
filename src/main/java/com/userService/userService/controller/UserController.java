package com.userService.userService.controller;

import com.userService.userService.model.UserRequest;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;

@RestController
class UserController {

    public HashMap<Integer, UserRequest> userMap = new HashMap<>();

    @GetMapping(value = "/user/{uniqueUserId}/userId/")
    public String getUserById(@PathVariable Integer uniqueUserId,
                              @PathParam(value = "userId") String theUserName) throws Exception {
        return "You requested Unique user id " + uniqueUserId + " Add the user name " + theUserName;
    }

    @PostMapping(value = "user/createUser")
    public UserRequest createUser(@RequestBody UserRequest userRequest) {
        userMap.put(userRequest.getUniqueUserId(),userRequest);
        return userRequest;
    }

    @PutMapping(value = "user/{UniqueUserId}/updateUser")
    public UserRequest updateUser(
            @PathVariable Integer UniqueQuestionId,
            @RequestBody UserRequest userRequest) {
        if (userMap.containsKey(UniqueQuestionId)){
            userMap.put(userRequest.getUniqueUserId(), userRequest);
        }
        return userRequest;
    }

    @DeleteMapping(value = "user/{userId}/delete")
    public String deleteUserById(@PathVariable Integer userId){
        if(userMap.containsKey(userId)){
            userMap.remove(userId);
            return  "Successfully deleted user with id " + userId;
        } else {
            return "Not existing user with id " + userId;
        }
    }

    @GetMapping(value = "user/{userId}")
    public UserRequest getUserById(@PathVariable Integer userId){
        return userMap.get(userId);
    }



}