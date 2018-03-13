package com.chenshun.test.util.servlet;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * User: mew <p />
 * Time: 18/3/13 11:10  <p />
 * Version: V1.0  <p />
 * Description: <p />
 */
@WebServlet(
        urlPatterns = {"/druid/*"},
        initParams = {
                @WebInitParam(name = "loginUsername", value = "roncoo"),
                @WebInitParam(name = "loginPassword", value = "roncoo")
        }
)
public class DruidStatViewServlet extends StatViewServlet {

    private static final long serialVersionUID = -6676282632114316559L;

}
