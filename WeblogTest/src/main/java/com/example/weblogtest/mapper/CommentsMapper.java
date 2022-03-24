package com.example.weblogtest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.weblogtest.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface CommentsMapper extends BaseMapper<Comment> {
   //根据blog id查找博客
   List<Comment> findBlogComment(@Param("id") Long id);

   /**
    * 添加评论
    * @param parent_comment_id 评论自关联
    * @param admin_comment 判断是不是作者自己的评论
    * @return
    */
   int addComments(@Param("avatar") String avatar, @Param("content") String content,
                   @Param("create_time") Date create_time, @Param("email") String email, @Param("nickname") String nickname,
                   @Param("blog_id") Long blog_id, @Param("parent_comment_id") Long parent_comment_id,
                   @Param("admin_comment") boolean admin_comment);
}
