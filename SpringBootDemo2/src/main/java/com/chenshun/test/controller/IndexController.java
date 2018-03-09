package com.chenshun.test.controller;

import com.chenshun.test.bean.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;

/**
 * User: mew <p />
 * Time: 18/3/8 16:00  <p />
 * Version: V1.0  <p />
 * Description: <p />
 */
@RestController
@RequestMapping(value = "/index")
public class IndexController {

    @Value(value = "${roncoo.secret}")
    private String secret;

    @Value(value = "${roncoo.number}")
    private int id;

    @Value(value = "${roncoo.desc}")
    private String desc;

    @RequestMapping
    public String index() {
        return "hello world";
    }

    // @RequestParam 简单类型的绑定，可以出来get和post
    @RequestMapping(value = "/get")
    public HashMap<String, Object> get(@RequestParam String name) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("title", "hello world");
        map.put("name", name);
        map.put("secret", secret);
        map.put("id", id);
        map.put("desc", desc);
        return map;
    }

    // @PathVariable 获得请求url中的动态参数
    @RequestMapping(value = "/get/{id}/{name}")
    public User getUser(@PathVariable int id, @PathVariable String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setDate(new Date());
        return user;
    }

    @RequestMapping(value = "/post")
    public ModelAndView post() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("test");
        return mv;
    }

}
