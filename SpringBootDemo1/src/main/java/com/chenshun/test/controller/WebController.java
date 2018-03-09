package com.chenshun.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: mew <p />
 * Time: 18/3/9 09:01  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Controller
@RequestMapping(value = "/web")
public class WebController {

    @RequestMapping(value = "index")
    public String index(ModelMap map) {
        map.put("title", "freemarker hello word1");
        // 开头不要加上/，linux下面会出错
        return "index";
    }

    @RequestMapping(value = "index2")
    public String index2(ModelMap map) {
        map.put("title", "freemarker hello word2");
        return "index2";
    }

    @RequestMapping(value = "error")
    public String error() {
        throw new RuntimeException("RuntimeException 测试异常");
    }

    @RequestMapping(value = "error2")
    public String error2() throws Exception {
        throw new Exception("Exception 测试异常");
    }

}
