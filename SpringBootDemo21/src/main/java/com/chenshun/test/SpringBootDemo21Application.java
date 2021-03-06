package com.chenshun.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.chenshun.test.mapper")
@SpringBootApplication
public class SpringBootDemo21Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemo21Application.class, args);
    }

}
