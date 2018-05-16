package com.chenshun.test.controller;

import com.chenshun.test.bean.User;
import com.chenshun.test.service.HelloService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: mew <p />
 * Time: 18/5/16 13:46  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@RestController
public class ConsumerController {

    @Autowired
    private HelloService2 helloService2;

    @GetMapping(value = "feignConsumer1")
    public String helloController1() {
        return helloService2.helloService("小肥猪");
    }

    @GetMapping(value = "feignConsumer2")
    public User helloController2() {
        return helloService2.helloService("chenshun", 111);
    }

    @GetMapping(value = "feignConsumer3")
    public String helloController3() {
        User user = new User("皮皮虾", 222);
        return helloService2.helloService(user);
    }

}
