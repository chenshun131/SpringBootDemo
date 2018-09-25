package com.chenshun.test.controller;

import org.springframework.web.bind.annotation.*;

/**
 * User: chenshun131 <p />
 * Time: 18/9/5 22:53  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }

}
