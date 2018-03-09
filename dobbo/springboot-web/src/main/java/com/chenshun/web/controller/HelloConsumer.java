package com.chenshun.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.chenshun.api.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: mew <p />
 * Time: 18/3/9 17:23  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Controller
@RequestMapping(value = "/api")
public class HelloConsumer {

    @Reference
    private HelloService helloService;

    @RequestMapping(value = "hello")
    public String hello() {
        return helloService.sayHellow();
    }

}
