package com.chenshun.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: chenshun131 <p />
 * Time: 18/3/31 12:43  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping("show")
    public String show() {
        return "这是测试方法";
    }

}
