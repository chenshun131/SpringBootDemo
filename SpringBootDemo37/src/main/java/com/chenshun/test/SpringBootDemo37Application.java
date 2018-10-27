package com.chenshun.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.chenshun.test.dao")
@SpringBootApplication
public class SpringBootDemo37Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemo37Application.class, args);
    }

}
