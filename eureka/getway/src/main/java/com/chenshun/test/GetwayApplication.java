package com.chenshun.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class GetwayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetwayApplication.class, args);
    }

}
