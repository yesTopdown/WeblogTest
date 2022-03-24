package com.example.weblogtest.Controller;

import com.example.weblogtest.pojo.*;
import com.example.weblogtest.service.BlogService;
import com.example.weblogtest.service.CommentService;
import com.example.weblogtest.service.TageService;
import com.example.weblogtest.service.TypesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@Slf4j
public class IndexController {
    @Autowired
    TageService tageService;
    @Autowired
    BlogService blogService;
    @Resource
    TypesService typesService;
    @Resource
    CommentService commentService;
  
    @GetMapping ("/")
    public String main(Model model, HttpSession session, @RequestParam(defaultValue = "1") Integer pages){
        int count = blogService.findCount(); //查询多少blog
        Page<Blog> pageList = blogService.findAllPage((pages-1)*3, 3, null);
        List<Tag> tags = tageService.findAllTags(); //查询所有标签
        List<Type> types = typesService.findAllTypes();//查询所有类型
        Page<Blog> recommendBlogs = blogService.findAllPage((pages-1)*3,3,null); //查找推荐的
        model.addAttribute("PageList",pageList);
        model.addAttribute("recommendBlogs",recommendBlogs.getList());
        model.addAttribute("tags",tags);
        model.addAttribute("types",types);
        session.setAttribute("PageCount",count);
        return "main";
    }
    @GetMapping("/blog/{id}")
    public String blogContent(@PathVariable(value = "id") Long id, Model model){
        log.info("id的用户==="+id);
        List<Blog> blogs = blogService.findBlogById(id);
        List<Comment> comments = commentService.findBlogComment(id);
        model.addAttribute("blogs",blogs);
        model.addAttribute("comments",comments);
        return "blog";
    }
    @GetMapping("/tags/{id}")
    public String tagsContent(@PathVariable("id") Long id, Model model){
        System.out.println("/tags/----------"+id);
        PageHelper.startPage(1,5);
        List<Blog> tagsBlogs = tageService.findTagsBlogs( id);
        PageInfo<Blog> page=new PageInfo<Blog>(tagsBlogs);
        List<Tag> tags = tageService.findAllTags();
        model.addAttribute("page",page);
        model.addAttribute("tags",tags);
        return "tags";
    }
    @GetMapping("/types/{id}")
    public String typesContent(@PathVariable("id") Long id, Model model){
        log.info("typesContent: "+id);
        Page<Blog> blogsByTypes = typesService.findBlogsByTypes(id, 0, 5);
        List<Type> types = typesService.findAllTypes(); //查找所有的type
        model.addAttribute("page",blogsByTypes);
        model.addAttribute("types",types);
        return "types";
    }

}
