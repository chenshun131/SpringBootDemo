package com.chenshun.test.service;

import com.chenshun.test.bean.User;
import com.chenshun.test.bean.UserLog;
import com.chenshun.test.dao.UserDao;
import com.chenshun.test.dao.UserLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * User: mew <p />
 * Time: 18/3/12 10:04  <p />
 * Version: V1.0  <p />
 * Description: <p />
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserLogDao userLogDao;

    /**
     * 用户注册
     *
     * @return
     */
    @Transactional
    public String register(String name, String ip) {
        // 1.添加用户
        User user = new User();
        user.setName(name);
        user.setCreateTime(new Date());
        userDao.insert(user);

        // 测试使用
        //boolean flag = true;
        //if (flag) {
        //	throw new RuntimeException();
        //}

        // 2.添加注册日志
        UserLog userLog = new UserLog();
        userLog.setUserName(name);
        userLog.setUserIp(ip);
        userLog.setCreateTime(new Date());
        userLogDao.save(userLog);

        return "success";
    }

}
