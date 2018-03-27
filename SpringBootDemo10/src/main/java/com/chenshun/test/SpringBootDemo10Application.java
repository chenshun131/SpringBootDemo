package com.chenshun.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync // 启用异步任务注解
@SpringBootApplication
public class SpringBootDemo10Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemo10Application.class, args);
    }

}
