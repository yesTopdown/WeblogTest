package com.example.weblogtest.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.weblogtest.Util.CookieUtil;
import com.example.weblogtest.Util.JsonUtil;
import com.example.weblogtest.Util.UUIDUtil;
import com.example.weblogtest.Vo.LoginVo;
import com.example.weblogtest.mapper.UserMapper;
import com.example.weblogtest.pojo.User;
import com.example.weblogtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

@Service
@Repository
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Override
    public List<User> findAll() {
        List<User> users = userMapper.findAll();
        return users;
    }

    @Override
    public List<User> findNameAndPass(String username, String password) {
        List<User> users = userMapper.findNameAndPass(username, password);
        return users;
    }

    @Override
    public List<User> checkName(String username) {
        List<User> users = userMapper.checkName(username);
        return users;
    }

    @Override
    public Integer saveUser(User user) {
        Integer integer = userMapper.saveUser(user);
        return integer;
    }

    @Override
    public User login(HttpServletRequest request, HttpServletResponse response, LoginVo loginVo) {
        String username=loginVo.getUsername();
        String password=loginVo.getPassword();
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("username",username);
        User user = userMapper.selectOne(wrapper);
        if (null==user){
            request.setAttribute("message","用户名或密码错误");
            return null;
        }else {
            //生成cookie
            String ticket = UUIDUtil.uuid();
            redisTemplate.opsForValue().set("user:" + ticket,
                    Objects.requireNonNull(JsonUtil.object2JsonStr(user)));
            request.getSession().setAttribute("user",user);
            CookieUtil.setCookie(request,response,"userTicket",ticket);
        }
        return user;
    }

    @Override
    public User getByUserTicket(String userTicket, HttpServletRequest request, HttpServletResponse response) {
        if(StringUtils.isEmpty(userTicket)){
            return null;
        }
        String userJson= (String) redisTemplate.opsForValue().get("user:" +
                userTicket);
        User user = JsonUtil.jsonStr2Object(userJson, User.class);
        if (null != user) {
            CookieUtil.setCookie(request,response,"userTicket",userTicket);
        }
        return user;
    }
}
