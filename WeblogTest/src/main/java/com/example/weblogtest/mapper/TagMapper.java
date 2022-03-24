package com.example.weblogtest.mapper;

import com.example.weblogtest.pojo.Blog;
import com.example.weblogtest.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface TagMapper {
    //查找标签
    List<Tag> findAllTags();
    //通过标签查找blog
    List<Blog>  findTagsBlogs(@Param("id") Long id);
}
