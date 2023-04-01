package com.xftxyz.rocketblog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.xftxyz.rocketblog.pojo.BlogWithUser;
import com.xftxyz.rocketblog.pojo.BlogWithUserExample;

public interface BlogWithUserMapper {

    // 获取热门博客
    @Select("SELECT v_blogwithuser.* " +
            "FROM v_blogwithuser " +
            "LEFT JOIN t_like ON v_blogwithuser.blog_id = t_like.blog_id " +
            "LEFT JOIN t_bookmark ON v_blogwithuser.blog_id = t_bookmark.blog_id " +
            "LEFT JOIN t_comment ON v_blogwithuser.blog_id = t_comment.blog_id " +
            "GROUP BY v_blogwithuser.blog_id " +
            "ORDER BY COUNT( DISTINCT t_like.userid )+ COUNT( DISTINCT t_bookmark.userid )+ COUNT( DISTINCT t_comment.comment_id ) DESC")
    List<BlogWithUser> selectHotBlogs();

    // 获取点赞最多的博客
    @Select("SELECT v_blogwithuser.* " +
            "FROM v_blogwithuser " +
            "LEFT JOIN t_like ON v_blogwithuser.blog_id = t_like.blog_id " +
            "GROUP BY v_blogwithuser.blog_id " +
            "ORDER BY COUNT( DISTINCT t_like.userid ) DESC")
    List<BlogWithUser> selectMostLikeBlogs();

    // 获取收藏最多的博客
    @Select("SELECT v_blogwithuser.* " +
            "FROM v_blogwithuser " +
            "LEFT JOIN t_bookmark ON v_blogwithuser.blog_id = t_bookmark.blog_id " +
            "GROUP BY v_blogwithuser.blog_id " +
            "ORDER BY COUNT( DISTINCT t_bookmark.userid ) DESC")
    List<BlogWithUser> selectMostCollectBlogs();

    // 获取评论最多的博客
    @Select("SELECT v_blogwithuser.* " +
            "FROM v_blogwithuser " +
            "LEFT JOIN t_comment ON v_blogwithuser.blog_id = t_comment.blog_id " +
            "GROUP BY v_blogwithuser.blog_id " +
            "ORDER BY COUNT( DISTINCT t_comment.comment_id ) DESC")
    List<BlogWithUser> selectMostCommentBlogs();

    // 获取收藏的博客
    @Select("SELECT v_blogwithuser.* " +
            "FROM v_blogwithuser " +
            "LEFT JOIN t_bookmark ON v_blogwithuser.blog_id = t_bookmark.blog_id " +
            "WHERE t_bookmark.userid = #{userid}")
    List<BlogWithUser> selectCollectBlogs(@Param("userid") Long userid);

    // 获取点赞的博客
    @Select("SELECT v_blogwithuser.* " +
            "FROM v_blogwithuser " +
            "LEFT JOIN t_like ON v_blogwithuser.blog_id = t_like.blog_id " +
            "WHERE t_like.userid = #{userid}")
    List<BlogWithUser> selectLikeBlogs(@Param("userid") Long userid);

    // 获取关注的所有人的博客
    @Select("SELECT v_blogwithuser.* " +
            "FROM v_blogwithuser " +
            "JOIN ( " +
            "SELECT userid_followed " +
            "FROM t_follow " +
            "WHERE userid_following = #{userid} " +
            ") f ON v_blogwithuser.userid = f.userid_followed")
    List<BlogWithUser> selectFollowBlogs(@Param("userid") Long userid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_blogwithuser
     *
     * @mbg.generated Sat Apr 01 00:16:22 CST 2023
     */
    long countByExample(BlogWithUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_blogwithuser
     *
     * @mbg.generated Sat Apr 01 00:16:22 CST 2023
     */
    int deleteByExample(BlogWithUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_blogwithuser
     *
     * @mbg.generated Sat Apr 01 00:16:22 CST 2023
     */
    int insert(BlogWithUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_blogwithuser
     *
     * @mbg.generated Sat Apr 01 00:16:22 CST 2023
     */
    int insertSelective(BlogWithUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_blogwithuser
     *
     * @mbg.generated Sat Apr 01 00:16:22 CST 2023
     */
    List<BlogWithUser> selectByExampleWithBLOBs(BlogWithUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_blogwithuser
     *
     * @mbg.generated Sat Apr 01 00:16:22 CST 2023
     */
    List<BlogWithUser> selectByExample(BlogWithUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_blogwithuser
     *
     * @mbg.generated Sat Apr 01 00:16:22 CST 2023
     */
    int updateByExampleSelective(@Param("record") BlogWithUser record, @Param("example") BlogWithUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_blogwithuser
     *
     * @mbg.generated Sat Apr 01 00:16:22 CST 2023
     */
    int updateByExampleWithBLOBs(@Param("record") BlogWithUser record, @Param("example") BlogWithUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_blogwithuser
     *
     * @mbg.generated Sat Apr 01 00:16:22 CST 2023
     */
    int updateByExample(@Param("record") BlogWithUser record, @Param("example") BlogWithUserExample example);
}