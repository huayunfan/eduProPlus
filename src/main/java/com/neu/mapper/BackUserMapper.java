package com.neu.mapper;

import com.neu.beans.User;

import java.sql.SQLException;

public interface BackUserMapper {
    public User findUserByName(String username) throws SQLException;
}
