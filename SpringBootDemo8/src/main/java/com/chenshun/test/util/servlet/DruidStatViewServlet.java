package com.chenshun.test.util.servlet;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(
        urlPatterns = {"/druid/*"},
        initParams = {
                @WebInitParam(name = "loginUsername", value = "roncoo"),
                @WebInitParam(name = "loginPassword", value = "roncoo")
        }
)
public class DruidStatViewServlet extends StatViewServlet {

    private static final long serialVersionUID = -5531431451794331482L;

}
