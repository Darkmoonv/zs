package com.zs.dao.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.zs.dao.UserDao;
import com.zs.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("userDao")
public class UserDaoImpl implements UserDao {
    @Resource(name ="JdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    public void save() {
        System.out.println("save running");
    }

    public User findUserAndPassword(String username, String password) throws EmptyResultDataAccessException {
        System.out.println(username+"----"+password);
        User user=jdbcTemplate.queryForObject("select * from users where username=? and password=?",new BeanPropertyRowMapper<User>(User.class),username,password);
        System.out.println(user);
        return user;
    }
}
