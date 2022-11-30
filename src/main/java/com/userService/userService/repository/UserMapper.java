package com.userService.userService.repository;

import com.userService.userService.model.UserRequest;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public  class UserMapper implements RowMapper <UserRequest>{

    @Override
    public UserRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new user(
                rs.getInt("user_id"),
                rs.getString("user_first_name"),
                rs.getString("user_last_name"),
                rs.getString("user_age"),
                rs.getString("user_email"),
                rs.getString("user_address"),
                rs.getString("user_date")
        );
    }
}



