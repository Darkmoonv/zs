package com.zs.dao;

import com.zs.domain.User;

public interface UserDao {
    public void save();
    public User findUserAndPassword(String username,String password);
}
