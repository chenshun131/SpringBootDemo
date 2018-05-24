package com.chenshun.test;

import com.chenshun.test.component.MyProps;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootDemo16Application {

//    @bean
//    @ConfigurationProperties(prefix = "myprops")
//    public MyProps myProps() {
//        return new MyProps();
//    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemo16Application.class, args);
    }

}
