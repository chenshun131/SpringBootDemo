package com.chenshun.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringCloudApplication
public class Consumer1Application {

    @Bean("restTemplate")
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean("restTemplate2")
    public RestTemplate restTemplate2() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(Consumer1Application.class, args);
    }

}
