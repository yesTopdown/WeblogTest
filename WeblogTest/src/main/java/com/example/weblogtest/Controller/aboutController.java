package com.example.weblogtest.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class aboutController {
    @Value("${aboutMeImageUrl}")
    private String aboutMeImageUrl;
    @Value("${aboutMeContent}")
    private String aboutMeContent;
    @GetMapping("/about")
    public String about(HttpSession session){
        session.setAttribute("aboutMeImageUrl",aboutMeImageUrl);
        session.setAttribute("aboutMeContent",aboutMeContent);
        return "about";
    }


}
