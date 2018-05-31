package com.chenshun.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class SpringBootDemo15Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemo15Application.class, args);
    }

}
