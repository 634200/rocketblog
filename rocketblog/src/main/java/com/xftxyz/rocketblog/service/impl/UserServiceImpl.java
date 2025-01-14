package com.xftxyz.rocketblog.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xftxyz.rocketblog.mapper.BlogMapper;
import com.xftxyz.rocketblog.mapper.ChatMapper;
import com.xftxyz.rocketblog.mapper.FollowMapper;
import com.xftxyz.rocketblog.mapper.UserMapper;
import com.xftxyz.rocketblog.mapper.VChatMapper;
import com.xftxyz.rocketblog.pojo.BlogExample;
import com.xftxyz.rocketblog.pojo.Chat;
import com.xftxyz.rocketblog.pojo.Follow;
import com.xftxyz.rocketblog.pojo.FollowExample;
import com.xftxyz.rocketblog.pojo.User;
import com.xftxyz.rocketblog.pojo.UserBase;
import com.xftxyz.rocketblog.pojo.UserExample;
import com.xftxyz.rocketblog.pojo.VChat;
import com.xftxyz.rocketblog.pojo.VChatExample;
import com.xftxyz.rocketblog.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    FollowMapper followMapper;

    @Autowired
    BlogMapper blogMapper;

    @Autowired
    ChatMapper chatMapper;

    @Autowired
    VChatMapper vChatMapper;

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
        exEmail.createCriteria().andEmailEqualTo(email).andPasswordEqualTo(password);
        List<User> userList = userMapper.selectByExample(exEmail);
        if (userList.size() < 1) {
            return null;
        }
        User user = userList.get(0);
        // 更新最后登录时间
        user.setLastLogin(new Date());
        userMapper.updateByPrimaryKey(user);
        return user;
    }

    @Override
    public Map<String, Object> getUserInfo(User user) {
        // 用户名、头像
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("username", user.getUsername());
        userInfo.put("avatar", user.getAvatar());

        // 关注: userid_following -> userid_followed

        // 关注数: followings
        FollowExample exFollowings = new FollowExample();
        exFollowings.createCriteria().andUseridFollowingEqualTo(user.getUserid());
        long followings = followMapper.countByExample(exFollowings);
        userInfo.put("followings", followings);

        // 粉丝数: followers
        FollowExample exFollowers = new FollowExample();
        exFollowers.createCriteria().andUseridFollowedEqualTo(user.getUserid());
        long followers = followMapper.countByExample(exFollowers);
        userInfo.put("followers", followers);

        // 文章数: blogs
        BlogExample exBlogs = new BlogExample();
        exBlogs.createCriteria().andUseridEqualTo(user.getUserid());
        long blogs = blogMapper.countByExample(exBlogs);
        userInfo.put("blogs", blogs);

        return userInfo;
    }

    @Override
    public Map<String, Object> getUserInfo(User me, Long userid) {
        User user = userMapper.selectByPrimaryKey(userid);
        // 用户名、头像
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("username", user.getUsername());
        userInfo.put("avatar", user.getAvatar());

        // 关注: userid_following -> userid_followed

        // 关注数: followings
        FollowExample exFollowings = new FollowExample();
        exFollowings.createCriteria().andUseridFollowingEqualTo(user.getUserid());
        long followings = followMapper.countByExample(exFollowings);
        userInfo.put("followings", followings);

        // 粉丝数: followers
        FollowExample exFollowers = new FollowExample();
        exFollowers.createCriteria().andUseridFollowedEqualTo(user.getUserid());
        long followers = followMapper.countByExample(exFollowers);
        userInfo.put("followers", followers);

        // 文章数: blogs
        BlogExample exBlogs = new BlogExample();
        exBlogs.createCriteria().andUseridEqualTo(user.getUserid());
        long blogs = blogMapper.countByExample(exBlogs);
        userInfo.put("blogs", blogs);

        // 是否关注: isFollowed
        if (me == null) {
            userInfo.put("isFollowed", false);

        } else {
            FollowExample exIsFollowed = new FollowExample();
            exIsFollowed.createCriteria().andUseridFollowingEqualTo(me.getUserid()).andUseridFollowedEqualTo(userid);
            long isFollowed = followMapper.countByExample(exIsFollowed);
            userInfo.put("isFollowed", isFollowed > 0);

        }

        return userInfo;
    }

    @Override
    public void follow(Long userFollowing, Long userFollowed) {
        Follow follow = new Follow();
        follow.setUseridFollowing(userFollowing);
        follow.setUseridFollowed(userFollowed);
        follow.setCreatetime(new Date());
        followMapper.insert(follow);
    }

    @Override
    public void cancelFollow(Long userFollowing, Long userFollowed) {
        FollowExample exFollow = new FollowExample();
        exFollow.createCriteria().andUseridFollowingEqualTo(userFollowing).andUseridFollowedEqualTo(userFollowed);
        followMapper.deleteByExample(exFollow);
    }

    @Override
    public List<UserBase> getFollowings(Long userid) {
        List<UserBase> followingUsers = userMapper.getFollowingUsers(userid);
        return followingUsers;
    }

    @Override
    public List<UserBase> getFollowers(Long userid) {
        List<UserBase> followerUsers = userMapper.getFollowedUsers(userid);
        return followerUsers;
    }

    @Override
    public int chat(Long fromUserid, Long toUserid, String content) {
        Chat chat = new Chat();
        chat.setUseridFrom(fromUserid);
        chat.setUseridTo(toUserid);
        chat.setMessageContent(content);
        chat.setCreatetime(new Date());
        int insert = chatMapper.insert(chat);
        return insert;
    }

    @Override
    public List<VChat> getChats(Long userid) {
        VChatExample exChats = new VChatExample();
        exChats.createCriteria().andUseridFromEqualTo(userid);
        exChats.setOrderByClause("createtime desc");
        List<VChat> chats = vChatMapper.selectByExample(exChats);
        return chats;
    }

    @Override
    public int deleteChat(Long chatid) {
        int delete = chatMapper.deleteByPrimaryKey(chatid);
        return delete;
    }

}
