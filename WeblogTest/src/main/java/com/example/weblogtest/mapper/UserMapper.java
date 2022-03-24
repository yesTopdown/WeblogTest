package com.example.weblogtest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.weblogtest.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface UserMapper extends BaseMapper<User>{
    //查找所有用户
    List<User> findAll();
    //查找密码和用户名
    List<User> findNameAndPass(@Param("username")String username, @Param("password")String password);
    //检查姓名是否可用
    List<User> checkName(@Param("username") String username);
    //保存用户 @Param("username")String username, @Param("password")String password,@Param("avatar")String avatar, @Param("email")String email,@Param("nickname")String nickname
    Integer saveUser(User user);
}
