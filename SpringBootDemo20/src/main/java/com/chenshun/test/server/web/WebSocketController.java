package com.chenshun.test.server.web;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

public class WebSocketController extends BaseController {

    DeviceAccountDao daDao = new DeviceAccountDao();

    @Override
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response, ModelAndView mav) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    //验证登录设备
    public ModelAndView doLoginVerify(HttpServletRequest request,
                                      HttpServletResponse response, ModelAndView mav) throws Exception {
        String deviceNm = StringUtil.Nvl(request.getParameter("deviceNm"));
        String devicePin = StringUtil.Nvl(request.getParameter("devicePin"));
        String type = deviceNm.startsWith("A") ? "A" : "B";
        DeviceAccount retDa = daDao.verifyDa(deviceNm, devicePin, type);
        if (!"notExsit".equals(retDa.getStatus())) {
            request.getSession(true).setAttribute("connectedDevice", retDa);
        }
        response.setHeader("Access-Control-Allow-Origin", "*");
        this.outJson(request, response, JSON.toJSONString(retDa));
        return null;
    }

}
