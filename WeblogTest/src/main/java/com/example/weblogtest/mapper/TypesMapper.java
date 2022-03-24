package com.example.weblogtest.mapper;

import com.example.weblogtest.pojo.Blog;
import com.example.weblogtest.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TypesMapper {
    List<Type> findAllTypes();
    List<Blog> findBlogsByTypes(@Param("id") Long id,@Param("offset") Integer page,@Param("size")Integer size);
    int findCountTypes();
}
