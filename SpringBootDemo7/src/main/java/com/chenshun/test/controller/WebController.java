package com.chenshun.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * User: mew <p />
 * Time: 18/3/12 14:24  <p />
 * Version: V1.0  <p />
 * Description: <p />
 */
@Controller
@RequestMapping("/web")
public class WebController {

    private static final Logger logger = LoggerFactory.getLogger(WebController.class);

    @RequestMapping("index")
    public String index(ModelMap map, HttpSession httpSession) {
        logger.info("这里是controller");
        map.put("title", "第一个应用：sessionID=" + httpSession.getId());
        // 注意，不要在最前面加上/，linux下面会出错\
        logger.info("sessionID=" + httpSession.getId());
        return "index";
    }

    @RequestMapping("error")
    public String error(ModelMap map) {
        throw new RuntimeException("测试异常");
    }

}
