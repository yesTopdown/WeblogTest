package com.example.weblogtest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.example.weblogtest.mapper")
@SpringBootApplication
public class WeblogTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(WeblogTestApplication.class, args);
    }
}
