package com.example.weblogtest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.weblogtest.pojo.Blog;
import com.example.weblogtest.pojo.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.context.annotation.Scope;

import java.util.List;

public interface BlogService extends IService<Blog> {
    //根据登录的用户确定显示的blog
    List<Blog> findAllBlog(Long id);
    //查找总页数
    int findCount();
    //分页查询
    Page<Blog> findAllPage(int pages, int quantity, Long id);
    //通过id查找用户
    List<Blog> findBlogById(Long id);
}
