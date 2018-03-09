package com.chenshun.test.util2.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: mew <p />
 * Time: 18/3/9 13:38  <p />
 * Version: V1.0  <p />
 * Description: <p />
 */
@WebServlet(name = "customServlet3", urlPatterns = "/roncoo3")
public class CustomServlet extends HttpServlet {

    private static final long serialVersionUID = -3554568680220680959L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("servlet get method3");
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("servlet post method3");
        response.getWriter().write("hello world3");
        response.flushBuffer();
    }

}
