package com.example.weblogtest.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.weblogtest.mapper.BlogMapper;
import com.example.weblogtest.pojo.Blog;
import com.example.weblogtest.pojo.Page;
import com.example.weblogtest.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {
    @Autowired
    BlogMapper blogMapper;

    /**
     * 查找用户的blog
     * @param id
     * @return
     */
    @Override
    public List<Blog> findAllBlog(Long id) {
        List<Blog> blogs = blogMapper.findAllBlog(id);
        return blogs;
    }

    /**
     * 查找总数
     * @return
     */
    @Override
    public int findCount() {
        int count = blogMapper.findCount();
        return count;
    }

    /**
     * 根据条件查询每页的内容
     * @param pages 当前页
     * @param quantity 每页显示数量
     *         id 哪位用户
     * @return
     */
    @Override
    public Page<Blog> findAllPage(int pages, int quantity, Long id) {
        Page<Blog> page;
        List<Blog> blogs = blogMapper.findAllPages(pages, quantity, id); //分页
        page=new Page<>(); //创建page函数
        page.setList(blogs); //加入list集合中
        page.setSize(blogs.size());//当前页的大小
        page.setPageNum(pages); //当前页
        int count = blogMapper.findCount(); //blog总数
        if(count!=0) {
            if (count % quantity > 0) {
                page.setPages((count / quantity) + 1);
            } else if (count % quantity == 0) {
                page.setPages(count / quantity);
            }
            if (pages == 0) {
                page.setFirstPage(true);//是否是第一页
            }
            //判断是不是最后一页
            if (count % quantity > 0 && pages == (count / quantity) + 1
                    || count % quantity == 0 && pages == count / quantity) {
                page.setLastPage(true);
            }
        }
        return page;
    }

    @Override
    public List<Blog> findBlogById(Long id) {
        List<Blog> blog = blogMapper.findBlogById(id);
        return blog;
    }
}
