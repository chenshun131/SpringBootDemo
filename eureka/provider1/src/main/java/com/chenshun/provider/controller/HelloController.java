package com.chenshun.provider.controller;

import com.chenshun.provider.bean.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * User: mew <p />
 * Time: 18/4/25 10:25  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @RequestMapping("print")
    public String print() {
        return "Hello print 111111";
    }

    @RequestMapping("user/{name}")
    public String user(@PathVariable("name") String name) {
        return "111111 user : " + name;
    }

    @RequestMapping("user2")
    public String user2(String name) {
        return "111111 user : " + name;
    }

    @RequestMapping(value = "user3/{names}", method = RequestMethod.PUT)
    public void user3(@PathVariable("names") String names, User user) {
        System.out.println("111111 " + names + " >>>>>>>>>>>>>>>" + user.toString());
    }

    @RequestMapping(value = "user4/{name}", method = RequestMethod.DELETE)
    public void user4(@PathVariable("name") String name) {
        System.out.println("111111 " + name);
    }

    @RequestMapping("hello")
    public String hello() throws InterruptedException {
        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(0, 5));
        return "Hello World";
    }

}
