package com.chenshun.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: mew <p />
 * Time: 18/3/9 10:55  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Controller
@RequestMapping(value = "error")
public class BaseErrorController implements ErrorController {

    private static final Logger logger = LoggerFactory.getLogger(BaseErrorController.class);

    @Override
    public String getErrorPath() {
        logger.info("出错啦！进入自定义错误控制器");
        return "comm/error";
    }

    @RequestMapping
    public String error() {
        return getErrorPath();
    }

}
