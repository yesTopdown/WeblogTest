package com.example.weblogtest.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_user")
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Object avatar;//头像
    private Date createTime=new Date();
    private String email;
    private String nickname;
    private String password  ;
    private Integer type;
    private Date updateTime=new Date();
    private String username;
    @TableField(exist = false)
    private List<Blog> blogs=new ArrayList<>();
}
