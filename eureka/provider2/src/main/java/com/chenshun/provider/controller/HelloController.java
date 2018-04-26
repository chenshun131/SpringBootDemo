package com.chenshun.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: mew <p />
 * Time: 18/4/25 10:28  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @RequestMapping("print")
    public String print() {
        return "Hello print 222222";
    }

}
