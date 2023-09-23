package com.firstProject.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private String address;
    private LocalDateTime joiningDate;
    private Boolean registered;


    public User(){}

    public User(Long id, String firstName, String lastName, String email, int age, String address, LocalDateTime joiningDate, Boolean registered) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.address = address;
        this.joiningDate = joiningDate;
        this.registered = registered;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public LocalDateTime getJoiningDate() {
        return joiningDate;
    }

    public Boolean getRegistered() {
        return registered;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setJoiningDate(LocalDateTime joiningDate) {
        this.joiningDate = joiningDate;
    }

    public void setRegistered(Boolean registered) {
        this.registered = registered;
    }
    public void register() {
        this.registered = true;
    }

    public void unregister() {
        this.registered = false;
    }

    public boolean isRegistered() {
        return registered;
    }
}