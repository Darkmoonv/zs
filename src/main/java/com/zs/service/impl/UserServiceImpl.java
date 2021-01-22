package com.zs.service.impl;

import com.zs.dao.UserDao;
import com.zs.domain.User;
import com.zs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("userService")
public class UserServiceImpl implements UserService {
    @Resource(name = "userDao")
    private UserDao userDao;

    public void save() {
        userDao.save();
    }

    public User login(String username,String password) {
         try {
             User user= userDao.findUserAndPassword(username,password);
             return user;
         }catch (EmptyResultDataAccessException e){
             e.printStackTrace();
             return null;
         }
    }
}
