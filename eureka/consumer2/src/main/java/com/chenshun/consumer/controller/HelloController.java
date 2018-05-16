package com.chenshun.consumer.controller;

import com.chenshun.consumer.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: chenshun131 <p />
 * Time: 18/5/1 22:24  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @HystrixCommand(fallbackMethod = "defaultRest")
    @RequestMapping("hello")
    public String hello() {
        return helloService.getUser();
    }

    public String defaultRest() {
        return "default HystrixCommand";
    }

}
