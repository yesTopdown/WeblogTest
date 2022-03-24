package com.example.weblogtest.service.Impl;

import com.example.weblogtest.mapper.TagMapper;
import com.example.weblogtest.pojo.Blog;
import com.example.weblogtest.pojo.Page;
import com.example.weblogtest.pojo.Tag;
import com.example.weblogtest.service.TageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TageServiceImpl implements TageService {
    @Autowired
    TagMapper tagMapper;
    Page<Tag> tagPage;
    @Override
    public List<Tag> findAllTags() {
        List<Tag> tags = tagMapper.findAllTags();
        return tags;
    }

    /**
     * 按条件查找相印的tags和Blogs
     * @param id 响应的id
     * @return
     */
    @Override
    public List<Blog> findTagsBlogs(Long id) {
        List<Blog> tagsBlogs = tagMapper.findTagsBlogs(id);
        return tagsBlogs;
    }
}
