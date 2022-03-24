package com.example.weblogtest.Controller;

import com.example.weblogtest.pojo.Blog;
import com.example.weblogtest.pojo.Comment;
import com.example.weblogtest.service.BlogService;
import com.example.weblogtest.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("blog")
public class BlogController {
    @Resource
    BlogService blogService;
    @Resource
    CommentService commentService;
    HashMap<Integer,List<Blog>> archives=new HashMap<>(); //进行blog分页
   //博客归档
    @GetMapping("/archives")
    public String archives(Model model){
        List<Blog> blog = blogService.findAllBlog(null);
        archives.put(1,blog);
        model.addAttribute("archiveMap",archives);
        return "archives";
    }
    //添加评论
    @PostMapping("/addComments")
    public String addComments(@RequestParam Comment comment,@RequestParam("blog_id") Long blogId){
        Date date=new Date();
        comment.setCreateTime(date);
        comment.getBlog().setId(blogId);
        commentService.addComments(comment);
        return "blog";
    }
}
