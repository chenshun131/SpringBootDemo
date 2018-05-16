package com.chenshun.test.controller;

import com.chenshun.test.bean.User;
import com.chenshun.test.service.RefactorRefactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: mew <p />
 * Time: 18/5/16 15:25  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@RestController
public class RefactorConsumerController {

    @Autowired
    private RefactorRefactService refactorHelloService;

    @GetMapping(value = "feignConsumer4")
    public String helloController1() {
        return refactorHelloService.helloService("小肥猪");
    }

    @GetMapping(value = "feignConsumer5")
    public User helloController2() {
        return refactorHelloService.helloService("chenshun", 111);
    }

    @GetMapping(value = "feignConsumer6")
    public String helloController3() {
        User user = new User("皮皮虾", 222);
        return refactorHelloService.helloService(user);
    }

}
