package com.chenshun.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

// @EnableRabbit
@EnableJms
@EnableCaching
@ServletComponentScan
@SpringBootApplication
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)
@ImportResource(locations = {"classpath:druid-bean.xml"})
public class SpringBootDemo7Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemo7Application.class, args);
    }

}
