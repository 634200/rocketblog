package com.xftxyz.rocketblog.pojo;

import java.util.Date;

public class Bookmark {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_bookmark.bookmark_id
     *
     * @mbg.generated Mon Mar 27 19:37:36 CST 2023
     */
    private Long bookmarkId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_bookmark.userid
     *
     * @mbg.generated Mon Mar 27 19:37:36 CST 2023
     */
    private Long userid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_bookmark.blog_id
     *
     * @mbg.generated Mon Mar 27 19:37:36 CST 2023
     */
    private Long blogId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_bookmark.createtime
     *
     * @mbg.generated Mon Mar 27 19:37:36 CST 2023
     */
    private Date createtime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_bookmark.bookmark_id
     *
     * @return the value of t_bookmark.bookmark_id
     *
     * @mbg.generated Mon Mar 27 19:37:36 CST 2023
     */
    public Long getBookmarkId() {
        return bookmarkId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_bookmark.bookmark_id
     *
     * @param bookmarkId the value for t_bookmark.bookmark_id
     *
     * @mbg.generated Mon Mar 27 19:37:36 CST 2023
     */
    public void setBookmarkId(Long bookmarkId) {
        this.bookmarkId = bookmarkId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_bookmark.userid
     *
     * @return the value of t_bookmark.userid
     *
     * @mbg.generated Mon Mar 27 19:37:36 CST 2023
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_bookmark.userid
     *
     * @param userid the value for t_bookmark.userid
     *
     * @mbg.generated Mon Mar 27 19:37:36 CST 2023
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_bookmark.blog_id
     *
     * @return the value of t_bookmark.blog_id
     *
     * @mbg.generated Mon Mar 27 19:37:36 CST 2023
     */
    public Long getBlogId() {
        return blogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_bookmark.blog_id
     *
     * @param blogId the value for t_bookmark.blog_id
     *
     * @mbg.generated Mon Mar 27 19:37:36 CST 2023
     */
    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_bookmark.createtime
     *
     * @return the value of t_bookmark.createtime
     *
     * @mbg.generated Mon Mar 27 19:37:36 CST 2023
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_bookmark.createtime
     *
     * @param createtime the value for t_bookmark.createtime
     *
     * @mbg.generated Mon Mar 27 19:37:36 CST 2023
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}