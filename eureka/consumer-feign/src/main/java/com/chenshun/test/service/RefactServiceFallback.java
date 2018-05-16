package com.chenshun.test.service;

import com.chenshun.test.bean.User;
import org.springframework.stereotype.Component;

/**
 * User: mew <p />
 * Time: 18/5/16 16:24  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Component
public class RefactServiceFallback implements HelloService2 {

    @Override
    public String helloService(String name) {
        return "error";
    }

    @Override
    public User helloService(String name, Integer age) {
        return new User("未知", 0);
    }

    @Override
    public String helloService(User user) {
        return "error";
    }

}
