package com.chenshun.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: chenshun131 <p />
 * Time: 18/7/15 22:40  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@RestController
public class TestController {

    @RequestMapping("hello")
    public String hello() {
        return "修改打包方式为war方式";
    }

}
