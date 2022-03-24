package com.example.weblogtest.Enum;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Data;

//发表标签
@AllArgsConstructor
public enum Flag {
    TRANS(1,"转载"),ORIGINAL(2,"原创");
    private String descp;
    Flag(int code,String descp) {
        this.code = code;
        this.descp = descp;
    }
    @EnumValue//标记数据库存的值是code
    private final int code;
}
