package com.example.weblogtest.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_website_info")
public class WebsiteInfo {
    /**
     * 网站各值名称
     */
    private String valueName;
    /**
     * 网站各值
     */
    private String value;
}
