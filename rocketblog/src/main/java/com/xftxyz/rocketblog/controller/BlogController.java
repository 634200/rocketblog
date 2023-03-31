package com.xftxyz.rocketblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xftxyz.rocketblog.pojo.Blog;
import com.xftxyz.rocketblog.pojo.BlogWithUser;
import com.xftxyz.rocketblog.pojo.Comment;
import com.xftxyz.rocketblog.pojo.User;
import com.xftxyz.rocketblog.result.Result;
import com.xftxyz.rocketblog.result.ResultCode;
import com.xftxyz.rocketblog.service.BlogService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogService blogService;

    @PostMapping("/publish")
    public Result<Object> publish(@RequestBody Blog blog, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return Result.fail(ResultCode.USER_NOT_LOGIN);
        }
        blog.setUserid(user.getUserid());
        blog.setBlogStatus(0);
        if (blog.getBlogTitle() == null || blog.getBlogTitle().equals("")) {
            blog.setBlogTitle("无标题");
        }
        // 日志：用户{}发布了博客{}
        log.info("用户{}发布了博客{}", user.getUsername(), blog.getBlogTitle());
        int insert = blogService.addBlog(blog);

        return Result.success(insert);
    }

    // 热门博客，分页返回
    @GetMapping("/hot")
    public Result<PageInfo<Blog>> hot(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Blog> hotBlogs = blogService.getHotBlogs();
        PageInfo<Blog> pageInfo = new PageInfo<>(hotBlogs);
        return Result.success(pageInfo);
    }

    // 最新发布，分页返回
    @GetMapping("/new")
    public Result<PageInfo<BlogWithUser>> newBlog(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<BlogWithUser> newBlogs = blogService.getNewBlogs();
        PageInfo<BlogWithUser> pageInfo = new PageInfo<>(newBlogs);
        return Result.success(pageInfo);
    }

    // 获取
    // 修改
    // 删除

    // 收藏
    @GetMapping("/collect/{blogId}")
    public Result<Object> collect(@PathVariable("blogId") Long blogId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return Result.fail(ResultCode.USER_NOT_LOGIN);
        }
        int collect = blogService.collect(user.getUserid(), blogId);
        return Result.success(collect);
    }

    // 取消收藏
    @DeleteMapping("/collect/{blogId}")
    public Result<Object> cancelCollect(@PathVariable("blogId") Long blogId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return Result.fail(ResultCode.USER_NOT_LOGIN);
        }
        int cancelCollect = blogService.cancelCollect(user.getUserid(), blogId);
        return Result.success(cancelCollect);
    }

    // 点赞
    @GetMapping("/like/{blogId}")
    public Result<Object> like(@PathVariable("blogId") Long blogId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return Result.fail(ResultCode.USER_NOT_LOGIN);
        }
        int like = blogService.like(user.getUserid(), blogId);
        return Result.success(like);
    }

    // 取消点赞
    @DeleteMapping("/like/{blogId}")
    public Result<Object> cancelLike(@PathVariable("blogId") Long blogId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return Result.fail(ResultCode.USER_NOT_LOGIN);
        }
        int cancelLike = blogService.cancelLike(user.getUserid(), blogId);
        return Result.success(cancelLike);
    }

    // 评论
    @PostMapping("/comment")
    public Result<Object> comment(@RequestBody Comment comment, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return Result.fail(ResultCode.USER_NOT_LOGIN);
        }
        comment.setUserid(user.getUserid());
        int insert = blogService.addComment(comment);
        return Result.success(insert);
    }

    // 删除评论
    @DeleteMapping("/comment/{commentId}")
    public Result<Object> deleteComment(@PathVariable("commentId") Long commentId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return Result.fail(ResultCode.USER_NOT_LOGIN);
        }
        int delete = blogService.deleteComment(commentId);
        return Result.success(delete);
    }

}
