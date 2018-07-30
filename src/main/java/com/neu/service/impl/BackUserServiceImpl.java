package com.neu.service.impl;

import com.neu.beans.User;
import com.neu.mapper.BackUserMapper;
import com.neu.service.BackUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
@Service
public class BackUserServiceImpl implements BackUserService {
    @Autowired
    BackUserMapper userMapper;
    @Override
    public boolean isLogin(String username, String password) {
        try {
            User user=userMapper.findUserByName(username);
            return user.getUserpassword().equals(password);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User getUserByName(String username) {
        try {
            return userMapper.findUserByName(username);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
