package com.example.weblogtest.Controller;
import com.example.weblogtest.Vo.LoginVo;
import com.example.weblogtest.mapper.UserMapper;
import com.example.weblogtest.pojo.User;
import com.example.weblogtest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

@Controller
@RequestMapping("/admin")
@Slf4j
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/login.os")
    public String Loginos(){
        return "/admin/login";
    }
    @RequestMapping("/register.os")
    public String Registeros(){
        return "/admin/register";
    }
    @PostMapping
    public String Index(HttpServletRequest request){
        request.setAttribute("message","请登录");
        return "/admin/login";
    }
    //登录功能
    @PostMapping("/login")
    public String login(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response){
        userService.login(request,response,loginVo);
        if(null!=loginVo){
            User user = userService.login(request, response, loginVo);
            if(null==user){
                return "admin/login";
            }
            return "admin/index";
        }else {
            return "admin/login";
        }
    }
    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session){
        session.removeAttribute("user");
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
    @PostMapping(value = "/regist",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ModelAndView register(User user, HttpServletRequest request,MultipartFile avatar) throws IOException {
        ModelAndView modelAndView=new ModelAndView();
        String filepath=null;
        String rPath=null;
        if(!avatar.isEmpty()) {
            String contextPath = request.getContextPath();
            String PATH = "D:\\前端\\WeblogTest\\WeblogTest\\src\\main\\resources\\static\\images";
            filepath = avatar.getOriginalFilename();
            int port=request.getLocalPort();
            rPath="http://localhost:"+port+contextPath+"/resources/static/images"+filepath;
            File targetFile=new File(PATH,filepath);
            PATH=PATH+"\\"+filepath;
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            try {
                avatar.transferTo(targetFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //根据用户名查询
        List<User> users = userService.checkName(user.getUsername());
        if(!users.isEmpty()){
            modelAndView.addObject("message","用户名已经存在");
            modelAndView.setViewName("/admin/regist");
        }else {
            user.setAvatar(rPath);
            userService.saveUser(user);
            modelAndView.setViewName("/admin/login");
        }
        return modelAndView;
    }
}
