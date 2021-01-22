package com.zs.service;

import com.zs.domain.User;

public interface UserService {
    public void save();
    public User login(String username,String password);
}
