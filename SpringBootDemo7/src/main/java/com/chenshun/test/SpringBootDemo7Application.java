package com.chenshun.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.jms.annotation.EnableJms;

// @EnableRabbit
@EnableJms
@EnableCaching
@ServletComponentScan
@SpringBootApplication
public class SpringBootDemo7Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemo7Application.class, args);
    }

}
