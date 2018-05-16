package com.chenshun.test.service;

import com.chenshun.test.bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * User: mew <p />
 * Time: 18/5/16 13:12  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@FeignClient(value = "HELLO-SERVICE-GROUP", fallback = RefactServiceFallback.class)
public interface HelloService2 {

    @RequestMapping("feign/hello1")
    String helloService(@RequestParam("name") String name);

    @GetMapping("feign/hello2")
    User helloService(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @PostMapping("feign/hello3")
    String helloService(@RequestBody User user);

}
