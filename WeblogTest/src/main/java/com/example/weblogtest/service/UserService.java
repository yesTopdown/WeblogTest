package com.example.weblogtest.service;

import com.example.weblogtest.Vo.LoginVo;
import com.example.weblogtest.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public interface UserService{
    //查找所有用户
    List<User> findAll();
    //查找密码和用户名
    List<User> findNameAndPass(String username, String password);
    //检查姓名是否可用
    List<User> checkName(String username);
    //保存用户 @Param("username")String username, @Param("password")String password,@Param("avatar")String avatar, @Param("email")String email,@Param("nickname")String nickname
    Integer saveUser(User user);
    User login(HttpServletRequest request, HttpServletResponse response, LoginVo loginVo);

    /**
     * 根据cookie获取用户
     * @param userTicket
     * @param request
     * @param response
     * @return
     */
    User getByUserTicket(String userTicket,HttpServletRequest
            request,HttpServletResponse response);
}
