package com.example.weblogtest.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginVo {
    private String username; //用户名
    private String password; //密码
}
