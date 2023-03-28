package com.xftxyz.rocketblog.service;

import java.util.List;

import com.xftxyz.rocketblog.pojo.Blog;

public interface BlogService {
    // 返回所有博客
    public List<Blog> getBlogs();

    // 返回指定标题、内容、用户、状态的博客
    public List<Blog> getBlogs(Blog blog);

    // 添加博客
    public int addBlog(Blog blog);

    // 删除博客
    public int deleteBlog(Long blogId);

    // 修改博客
    public int updateBlog(Blog blog);

}