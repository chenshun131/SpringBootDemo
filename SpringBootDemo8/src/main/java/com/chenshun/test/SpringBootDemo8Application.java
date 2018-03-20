package com.chenshun.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@ServletComponentScan
@EnableSwagger2
@EnableTransactionManagement
@ImportResource(locations = {"classpath:druid-bean.xml"})
@SpringBootApplication
public class SpringBootDemo8Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemo8Application.class, args);
    }

}
