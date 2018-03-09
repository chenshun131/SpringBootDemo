package com.chenshun.test.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * User: mew <p />
 * Time: 18/3/9 9:39  <p />
 * Version: V1.0  <p />
 * Description: <p />
 */
@Controller
@RequestMapping(value = "/web")
public class WebController {

    /** 从 application.properties 中读取配置，如取不到默认值为Hello */
    @Value("${application.hello:Hello}")
    private String hello;

    @RequestMapping(value = "index")
    public String index(ModelMap map) {
        map.put("title", "thymeleaf hello word");
        map.put("hello", hello);
        return "index";
    }

}
