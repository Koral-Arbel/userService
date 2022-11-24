package com.userService.userService.repository.mapper;


import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepositoryImpl<userMapper> implements UsersRepositoryImpl {
    private static final String User_Table_Name = "User";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Long createUser(User user){
        String sql = "INSERT INTO" + User_Table_Name + "(user_id, user_first_name, user_last_name, user_email, user_age, user_address, user_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getFullName());
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
    }

    @Override
    public void updateUserById(Long userId, User user) {
        String sql = "UPDATE" + User_Table_Name + "WHERE id=?";
        jdbcTemplate.update(sql, userId);

    }

    @Override
    public void deleteUserById(Long id) {
        String sql = "DELETE FROM" + User_Table_Name + "WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public User getUserById(Long id) {
        String sql = "SELECT + FROM " + User_Table_Name + "WHERE id=?";
        return (User) jdbcTemplate.queryForObject(sql, new UserMapper(), id);
    }}

