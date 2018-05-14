package com.chenshun.test.controller;

import com.chenshun.test.component.MyProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: mew <p />
 * Time: 18/5/9 10:47  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@RestController
public class HelloController {

    @Value("${jdbc.driverClass:11}")
    public int driver1;

    @RequestMapping("run1")
    public Integer run1() {
        return driver1;
    }

    @Value("${jdbc.driverClass.noexist:defaultValue}")
    public String driver2;

    @RequestMapping("run2")
    public String run2() {
        return driver2;
    }

    @Autowired
    private MyProps myProps;

    @RequestMapping("run3")
    public MyProps run3() {
        return myProps;
    }

}
