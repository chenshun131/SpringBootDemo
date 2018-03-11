package com.chenshun.test.util.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: mew <p />
 * Time: 18/3/11 22:13  <p />
 * Version: V1.0  <p />
 * Description: 自定义servlet <p />
 */
@WebServlet(urlPatterns = "/roncoo", name = "customServlet")
public class CustomServlet extends HttpServlet {

    private static final long serialVersionUID = -4286721285446060392L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("servlet get method");
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("servlet post method");
        response.getWriter().write("hello world");
    }

}
