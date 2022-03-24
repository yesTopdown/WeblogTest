package com.example.weblogtest.service;

import com.example.weblogtest.pojo.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentService {
    //查找用户的评论
    List<Comment> findBlogComment(Long id);
    //添加博客评论
    int addComments(Comment comment);
}
