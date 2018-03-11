package com.chenshun.test.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * User: mew <p />
 * Time: 18/3/9 13:58  <p />
 * Version: V1.0  <p />
 * Description: <p />
 */
@RestController
@RequestMapping(value = "/api", method = {RequestMethod.GET, RequestMethod.POST})
public class ApiController {

    @RequestMapping(value = "/get1")
    public HashMap<String, Object> get1(@RequestParam String name) {
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("title", "hello world");
        map.put("name", name);
        return map;
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/get2")
    public HashMap<String, Object> get2(@RequestParam String name) {
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("title", "hello world");
        map.put("name", name);
        return map;
    }

}
