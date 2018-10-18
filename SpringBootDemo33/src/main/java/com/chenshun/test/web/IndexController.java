package com.chenshun.test.web;

import com.chenshun.test.entity.User;
import com.chenshun.test.service.UserService;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * User: chenshun131 <p />
 * Time: 18/10/13 14:13  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@RestController
public class IndexController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    @ResponseBody
    public List<User> users() {
        return userService.list();
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public User findUserById(@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }

    @GetMapping("/info/{id}")
    @ResponseBody
    public User findInfoById(@PathVariable("id") Long id) {
        return userService.findInfoById(id);
    }

    @GetMapping("/user/{id}/{name}")
    @ResponseBody
    public Map update(@PathVariable("id") Long id, @PathVariable("name") String name) {
        User user = userService.findUserById(id);
        user.setName(name);
        userService.update(user);
        return ImmutableMap.of("ret", 0, "msg", "ok");
    }

}
