package com.chenshun.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@ServletComponentScan
@EnableSwagger2
@SpringBootApplication
@ImportResource(locations = {"classpath:druid-bean.xml"})
public class SpringBootDemo8Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemo8Application.class, args);
    }

}
