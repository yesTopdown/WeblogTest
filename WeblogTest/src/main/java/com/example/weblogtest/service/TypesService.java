package com.example.weblogtest.service;

import com.example.weblogtest.pojo.Blog;
import com.example.weblogtest.pojo.Page;
import com.example.weblogtest.pojo.Type;

import java.util.List;

public interface TypesService {
    //查找全部分类
    List<Type> findAllTypes();
    //查询与types相关的blogs
    Page<Blog> findBlogsByTypes(Long id, Integer offset, Integer size);
}
