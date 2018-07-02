package com.chenshun.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrix
@EnableHystrixDashboard
@EnableEurekaClient
@SpringCloudApplication
public class Provider2Application {

    public static void main(String[] args) {
        SpringApplication.run(Provider2Application.class, args);
    }

}
