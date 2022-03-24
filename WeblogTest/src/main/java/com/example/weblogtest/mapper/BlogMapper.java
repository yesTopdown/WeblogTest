package com.example.weblogtest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.weblogtest.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface BlogMapper extends BaseMapper<Blog> {
    //根据登录的用户确定显示的blog
    List<Blog> findAllBlog(Long id);
    //分页查询。
    List<Blog> findAllPages(@Param("page") Integer page,@Param("size")Integer size,@Param("id") Long id);
    //查找总页数
    int findCount();
    //通过id查找blog
    List<Blog> findBlogById(Long id);
}
