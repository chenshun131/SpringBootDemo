package com.chenshun.springbootdemo19.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: mew <p />
 * Time: 18/5/31 10:16  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Controller
public class HelloController {

    @RequestMapping("hello")
    public String hello(ModelMap model) {
        model.addAttribute("name", "chenshun");
        return "hello";
    }

}
