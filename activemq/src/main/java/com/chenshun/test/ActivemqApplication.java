package com.chenshun.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//@EnableJms
@ImportResource(locations = "classpath:spring-activemq.xml")
@SpringBootApplication
public class ActivemqApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivemqApplication.class, args);
    }

}
