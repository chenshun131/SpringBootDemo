package com.chenshun.test.controller;

import com.chenshun.test.bean.Score;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: mew <p />
 * Time: 18/4/19 09:43  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@RequestMapping("hello")
@RestController
public class HelloController {

    @RequestMapping("print")
    public Score print(String name, String score) {
        return new Score(name, score);
    }

}
