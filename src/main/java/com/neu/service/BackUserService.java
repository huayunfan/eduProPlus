package com.neu.service;

import com.neu.beans.User;

public interface BackUserService {
    public boolean isLogin(String username,String password);
    public User getUserByName(String username);
}
