package com.example.weblogtest.mapper;

import com.example.weblogtest.pojo.Blog;
import com.example.weblogtest.pojo.Tag;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class TagMapperTest {
  @Autowired
  TagMapper tagMapper;
    @Test
    void findTagsBlogs() {
//        List<Tag> tagsBlogs = tagMapper.findTagsBlogs("`t_blog`.`id`", 4L);
//        for (Tag tagsBlog : tagsBlogs) {
//            System.out.println(tagsBlog);
//        }
    }
}