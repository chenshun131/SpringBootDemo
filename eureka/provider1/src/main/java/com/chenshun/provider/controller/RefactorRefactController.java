package com.chenshun.provider.controller;

import com.chenshun.test.base.RefactService;
import com.chenshun.test.bean.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: mew <p />
 * Time: 18/5/16 15:13  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@RestController
public class RefactorRefactController implements RefactService {

    @Override
    public String helloService(@RequestParam("name") String name) {
        return "1111 Hello " + name;
    }

    @Override
    public User helloService(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        return new User(name, age);
    }

    @Override
    public String helloService(@RequestBody User user) {
        return "1111 Hello " + user.getName() + ", " + user.getAge();
    }

}
