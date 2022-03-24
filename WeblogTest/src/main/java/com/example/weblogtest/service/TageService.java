package com.example.weblogtest.service;

import com.example.weblogtest.pojo.Blog;
import com.example.weblogtest.pojo.Page;
import com.example.weblogtest.pojo.Tag;
import com.example.weblogtest.pojo.Type;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TageService {
    //查找所有的tag
    List<Tag> findAllTags();
    //按条件查询 blogs
    List<Blog>  findTagsBlogs( Long id);
}
