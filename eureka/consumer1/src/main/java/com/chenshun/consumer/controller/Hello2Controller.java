package com.chenshun.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * User: chenshun131 <p />
 * Time: 18/5/10 22:12  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@RestController("hello2")
public class Hello2Controller {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("test1")
    public String test1() {
        // 方式1> 直接使用 restTemplate，url 写死
        ResponseEntity<String> responseEntity =
                restTemplate.getForEntity("http://localhost:8080/hello/user2?name=chenshun", String.class);
        return responseEntity.getBody();
    }

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("test2")
    public String test2() {
        // 方式2> 利用 loadBalanceClient 通过应用名获取 url ，然后再使用 restTemplate
        ServiceInstance serviceInstance = loadBalancerClient.choose("HELLO-SERVICE-GROUP");
        String url = String.format("http://%s:%s/hello/user2?name=chenshun", serviceInstance.getHost(), serviceInstance.getPort());
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        return responseEntity.getBody();
    }

    @RequestMapping("test3")
    public String test3() {
        // 方式3> 利用 @LoadBalanced，可在 restTemplate 里使用应用名字
        ResponseEntity<String> responseEntity =
                restTemplate.getForEntity("http://HELLO-SERVICE-GROUP/hello/user2?name=chenshun", String.class);
        return responseEntity.getBody();
    }

}
