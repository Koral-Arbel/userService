package com.userService.userService.model;

import java.time.DateTimeException;

public class UserRequest {
    private Integer uniqueUserId;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userAge;
    private String userAddress;
    private DateTimeException userJoiningDate;

    public UserRequest() {
        this.uniqueUserId = uniqueUserId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userAge = userAge;
        this.userAddress = userAddress;
        this.userJoiningDate = userJoiningDate;
    }

    public Integer getUniqueUserId() {
        return uniqueUserId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserAge() {
        return userAge;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public DateTimeException getUserJoiningDate() {
        return userJoiningDate;
    }

    public void setUniqueUserId(Integer uniqueUserId) {
        this.uniqueUserId = uniqueUserId;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public void setUserJoiningDate(DateTimeException userJoiningDate) {
        this.userJoiningDate = userJoiningDate;
    }
}