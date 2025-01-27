package com.xftxyz.rocketblog.service;

import java.util.List;
import java.util.Map;

import com.xftxyz.rocketblog.pojo.User;
import com.xftxyz.rocketblog.pojo.UserBase;
import com.xftxyz.rocketblog.pojo.VChat;

public interface UserService {
    // 获取用户列表
    public List<User> getUsers();

    // 获取用户
    public User getUser(Long id);

    // 添加用户
    public int addUser(User user);

    // 删除用户
    public int deleteUser(Long id);

    // 更新用户
    public int updateUser(User user);

    public List<User> getUserByName(String name);

    public List<User> getUserByEmail(String email);

    public String register(String name, String password, String email);

    public User login(String email, String password);

    // 获取用户信息
    public Map<String, Object> getUserInfo(User user);
    public Map<String, Object> getUserInfo(User me, Long userid);

    public void follow(Long userFollowing, Long userFollowed);

    public void cancelFollow(Long userFollowing, Long userFollowed);

    // 获取用户关注列表
    public List<UserBase> getFollowings(Long userid);

    // 获取用户粉丝列表
    public List<UserBase> getFollowers(Long userid);

    public int chat(Long fromUserid, Long toUserid, String content);

    public List<VChat> getChats(Long userid);

    public int deleteChat(Long chatid);


}
