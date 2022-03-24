package com.example.weblogtest.Page;

import com.example.weblogtest.mapper.BlogMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class BlogPage {
    @Resource
    BlogMapper blogMapper;

}
