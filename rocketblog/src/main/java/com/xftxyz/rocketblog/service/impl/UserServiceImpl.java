package com.xftxyz.rocketblog.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xftxyz.rocketblog.mapper.UserMapper;
import com.xftxyz.rocketblog.pojo.User;
import com.xftxyz.rocketblog.pojo.UserExample;
import com.xftxyz.rocketblog.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getUsers() {
        List<User> users = userMapper.selectByExample(null);
        return users;
    }

    @Override
    public User getUser(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public int addUser(User user) {
        int insert = userMapper.insert(user);
        return insert;
    }

    @Override
    public int deleteUser(Long id) {
        int delete = userMapper.deleteByPrimaryKey(id);
        return delete;
    }

    @Override
    public int updateUser(User user) {
        int update = userMapper.updateByPrimaryKey(user);
        return update;
    }

    @Override
    public List<User> getUserByName(String name) {
        UserExample exName = new UserExample();
        exName.createCriteria().andUsernameLike("%" + name + "%");
        List<User> userList = userMapper.selectByExample(exName);
        return userList;
    }

    @Override
    public List<User> getUserByEmail(String email) {
        UserExample exEmail = new UserExample();
        exEmail.createCriteria().andEmailLike("%" + email + "%");
        List<User> userList = userMapper.selectByExample(exEmail);
        return userList;
    }

    @Override
    public String register(String name, String password, String email) {
        // UserExample exName = new UserExample();
        // exName.createCriteria().andUsernameEqualTo(name);
        // List<User> userList = userMapper.selectByExample(exName);
        // if (userList.size() > 0) {
        // return "用户名已存在";
        // }
        UserExample exEmail = new UserExample();
        exEmail.createCriteria().andEmailEqualTo(email);
        long countEmail = userMapper.countByExample(exEmail);
        if (countEmail > 0) {
            return "邮箱已存在";
        }
        User user = new User();
        user.setUsername(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setUserRegisterTime(new Date());
        userMapper.insert(user);
        return "注册成功";
    }

    @Override
    public User login(String email, String password) {
        UserExample exEmail = new UserExample();
        exEmail.createCriteria().andEmailEqualTo(email);
        List<User> userList = userMapper.selectByExample(exEmail);
        if (userList.size() == 0) {
            return null;
        }
        User user = userList.get(0);
        if (user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

}
