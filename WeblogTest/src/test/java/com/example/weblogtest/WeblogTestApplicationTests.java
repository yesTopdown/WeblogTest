package com.example.weblogtest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.weblogtest.mapper.*;
import com.example.weblogtest.pojo.Blog;
import com.example.weblogtest.pojo.Comment;
import com.example.weblogtest.pojo.Type;
import com.example.weblogtest.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@Slf4j
class WeblogTestApplicationTests {
    @Autowired
    BlogMapper blogMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    TagMapper tagMapper;
    @Autowired
    TypesMapper typesMapper;
    @Resource
    CommentsMapper commentsMapper;
    @Test
    public void muptest(){
//        List<Blog> blogsByTypes = typesMapper.findBlogsByTypes(23L,null,null);
//        for (Blog blogsByType : blogsByTypes) {
//            System.out.println(blogsByType);
//        }
    }

    @Test
    public void mplustest(){
//        Page<Blog> page=new Page<>(1,5);
//        IPage<Blog> blogIPage = blogMapper.selectPageVo(page, null);
//        List<Blog> records = blogIPage.getRecords();
//        System.out.println("总数：  "+blogIPage.getTotal());
//        for (Blog record : records) {
//            System.out.println(record);
//        }
        List<Blog> blog = blogMapper.findBlogById(13L);
        for (Blog blog1 : blog) {
            log.info("blog的用户==="+blog1.getUser().getAvatar());
        }
        List<Comment> comment = commentsMapper.findBlogComment(13L);
        log.info("comment:  "+comment);
    }
    @Test
    void saveName(){
      /*  List<Tag> allTags = tagMapper.findAllTags();
        for (Tag allTag : allTags) {
            log.info("标签： "+allTag);
        }*/
        List<Type> types = typesMapper.findAllTypes();
        for (Type type : types) {
            log.info("types: "+type);
        }
    }
    @Test
    void checkName(){
//        List<User> all = userMapper.findAll();
//        for (User user : all) {
//            System.out.println(user);
//        }
        List<Blog> blogById = blogMapper.findBlogById(5L);
        log.info("blogs: "+blogById);
    }
    @Test
    void contextLoads() {
//        设置分页相关参数   当前页+每页显示的条数
        List<Blog> allPages = blogMapper.findAllPages(0, 2,null);
        for (Blog allPage : allPages) {
            System.out.println("====================================");
            System.out.println(allPage);
            System.out.println("====================================");
        }
        log.info("数量： "+allPages.size());

    }
    @Test
    void mapper(){
        List<Blog> allBlog = blogMapper.findAllBlog(null);
        for (Blog blog : allBlog) {
            System.out.println(blog);
        }
    }

}
