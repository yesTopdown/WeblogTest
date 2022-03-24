package com.example.weblogtest.service.Impl;

import com.example.weblogtest.mapper.CommentsMapper;
import com.example.weblogtest.pojo.Comment;
import com.example.weblogtest.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    CommentsMapper commentsMapper;
    @Override
    public List<Comment> findBlogComment(Long id) {
        return commentsMapper.findBlogComment(id);
    }

    @Override
    public int addComments(Comment comment) {
        commentsMapper.addComments(comment.getAvatar(),comment.getContent(),
                comment.getCreateTime(),comment.getEmail(),
                comment.getNickname(),comment.getBlog().getId(),
                comment.getParentComment().getId(),comment.isAdminComment());
        return 0;
    }
}
