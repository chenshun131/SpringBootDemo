package com.chenshun.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: mew <p />
 * Time: 18/5/18 10:13  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@RefreshScope
@RestController
public class TestController {

    @Value("${from}")
    private String from;

    @Autowired
    private Environment environment;

    @RequestMapping("from")
    public String from() {
        return this.from;
    }

    @RequestMapping("from1")
    public String from1() {
        return environment.getProperty("from", "undefined");
    }

}
