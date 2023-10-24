package com.firstProject.repository;

import com.firstProject.model.User;
import com.firstProject.model.UserResponse;
import com.firstProject.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String TABLE_NAME_USER = "user";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public User createUser(User user, UserResponse userResponse) {
        String sql = "INSERT INTO " + TABLE_NAME_USER + " " + "(first_name, last_name, email, age, address, join_date, registered) values (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getAge(),
                user.getAddress(),
                user.getJoiningDate(),
                userResponse.isRegistered());
        Long userId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
        System.out.println("User save to data base");
        return getUserById(userId);
    }

    @Override
    public User updateUser(User user) {
        String sql = "UPDATE " + TABLE_NAME_USER + " SET first_name=?, last_name=?, email=?, age=?, address=?, join_date=?, registered=? WHERE id=?";
        jdbcTemplate.update(
                sql,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getAge(),
                user.getAddress(),
                user.getId()
        );
        return getUserById(user.getId());

    }

    @Override
    public void deleteUser(Long id) {
        String sql = "DELETE FROM " + TABLE_NAME_USER + " WHERE id=?";
        jdbcTemplate.update(sql, id);

    }

    @Override
    public User getUserById(Long id) {
        String sql = "SELECT * FROM " + TABLE_NAME_USER + " WHERE id=?";
        try {
            return (User) jdbcTemplate.queryForObject(sql, new UserMapper(), id);
        } catch (EmptyResultDataAccessException exception) {
            return null;
        }
    }
    @Override
    public User getUserByEmail(String email) {
        String sql = "SELECT * FROM " + TABLE_NAME_USER + " WHERE email=?";
        try {
            return jdbcTemplate.queryForObject(sql, new UserMapper(), email);
        } catch (EmptyResultDataAccessException exception) {
            return null;
        }
    }
    @Override
    public List<User> getUsers() {
        String sql = "SELECT * FROM " + TABLE_NAME_USER;
        try {
            return jdbcTemplate.query(sql, new UserMapper());
        } catch (EmptyResultDataAccessException exception) {
            return null;
        }
    }

    @Override
    public List<User> getUsersByFirstName(String firstName) {
        String sql = "SELECT * FROM " + TABLE_NAME_USER + " WHERE first_name=?";
        try {
            return jdbcTemplate.query(sql, new UserMapper(), firstName);
        } catch (EmptyResultDataAccessException exception) {
            return null;
        }
    }
}

