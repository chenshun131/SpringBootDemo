package com.chenshun.provider.controller;

import com.chenshun.provider.bean.User;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * User: mew <p />
 * Time: 18/5/16 14:13  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@RequestMapping("feign")
@RestController
public class FeignController {

    @GetMapping("/hello1")
    public String hello(@RequestParam("name") String name) throws InterruptedException {
        TimeUnit.SECONDS.sleep(60);
        return "1111 Hello " + name;
    }

    @GetMapping("/hello2")
    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        return new User(name, age);
    }

    @PostMapping("/hello3")
    public String hello(@RequestBody User user) {
        return "1111 Hello " + user.getName() + ", " + user.getAge();
    }

}
