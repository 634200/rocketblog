package com.xftxyz.rocketblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xftxyz.rocketblog.pojo.Blog;
import com.xftxyz.rocketblog.pojo.BlogDetail;
import com.xftxyz.rocketblog.pojo.BlogInfo;
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
    public Result<PageInfo<BlogInfo>> hot(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<BlogInfo> hotBlogs = blogService.getHotBlogs();
        PageInfo<BlogInfo> pageInfo = new PageInfo<>(hotBlogs);
        return Result.success(pageInfo);
    }

    // 点赞最多
    @GetMapping("/hot/like")
    public Result<PageInfo<BlogInfo>> hotLike(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<BlogInfo> hotBlogs = blogService.getMostLikeBlogs();
        PageInfo<BlogInfo> pageInfo = new PageInfo<>(hotBlogs);
        return Result.success(pageInfo);
    }

    // 收藏最多
    @GetMapping("/hot/collect")
    public Result<PageInfo<BlogInfo>> hotCollect(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<BlogInfo> hotBlogs = blogService.getMostCollectBlogs();
        PageInfo<BlogInfo> pageInfo = new PageInfo<>(hotBlogs);
        return Result.success(pageInfo);
    }

    // 评论最多
    @GetMapping("/hot/comment")
    public Result<PageInfo<BlogInfo>> hotComment(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<BlogInfo> hotBlogs = blogService.getMostCommentBlogs();
        PageInfo<BlogInfo> pageInfo = new PageInfo<>(hotBlogs);
        return Result.success(pageInfo);
    }

    // 最新发布，分页返回
    @GetMapping("/new")
    public Result<PageInfo<BlogInfo>> newBlog(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<BlogInfo> newBlogs = blogService.getNewBlogs();
        PageInfo<BlogInfo> pageInfo = new PageInfo<>(newBlogs);
        return Result.success(pageInfo);
    }

    // 获取我关注的人的博客
    @GetMapping("/follows")
    public Result<PageInfo<BlogInfo>> getFollows(int pageNum, int pageSize, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return Result.fail(ResultCode.USER_NOT_LOGIN);
        }
        PageHelper.startPage(pageNum, pageSize);
        List<BlogInfo> follows = blogService.getFollowsBlogs(user.getUserid());
        PageInfo<BlogInfo> pageInfo = new PageInfo<>(follows);
        return Result.success(pageInfo);
    }

    // 获取博客详情
    @GetMapping("/detail/{blogId}")
    public Result<BlogDetail> detail(@PathVariable("blogId") Long blogId) {
        BlogDetail blog = blogService.getBlogDetail(blogId);
        return Result.success(blog);
    }

    // 修改
    @PutMapping("/update")
    public Result<Object> update(@RequestBody Blog blog, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return Result.fail(ResultCode.USER_NOT_LOGIN);
        }
        // blog.setUserid(user.getUserid());
        int update = blogService.updateBlog(blog);
        return Result.success(update);
    }
    
    // 删除
    @DeleteMapping("/delete/{blogId}")
    public Result<Object> delete(@PathVariable("blogId") Long blogId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return Result.fail(ResultCode.USER_NOT_LOGIN);
        }
        int delete = blogService.deleteBlog(blogId);
        return Result.success(delete);
    }

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

    // 获取收藏的博客
    @GetMapping("/collects")
    public Result<PageInfo<BlogInfo>> getCollects(int pageNum, int pageSize, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return Result.fail(ResultCode.USER_NOT_LOGIN);
        }
        PageHelper.startPage(pageNum, pageSize);
        List<BlogInfo> collects = blogService.getCollectsBlogs(user.getUserid());
        PageInfo<BlogInfo> pageInfo = new PageInfo<>(collects);
        return Result.success(pageInfo);
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

    // 获取点赞的博客
    @GetMapping("/likes")
    public Result<PageInfo<BlogInfo>> getLikes(int pageNum, int pageSize, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return Result.fail(ResultCode.USER_NOT_LOGIN);
        }
        PageHelper.startPage(pageNum, pageSize);
        List<BlogInfo> likes = blogService.getLikesBlogs(user.getUserid());
        PageInfo<BlogInfo> pageInfo = new PageInfo<>(likes);
        return Result.success(pageInfo);
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

    // 获取评论
    // @GetMapping("/comment/{blogId}")
    // public Result<List<Comment>> getComments(@PathVariable("blogId") Long blogId)
    // {
    // List<Comment> comments = blogService.getComments(blogId);
    // return Result.success(comments);
    // }

}
