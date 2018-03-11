package com.chenshun.test;

import com.chenshun.test.bean.User;
import com.chenshun.test.dao.UserDao;
import com.chenshun.test.util.base.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemo4ApplicationTests {

    @Autowired
    private UserDao roncooUserDao;

    @Test
    public void insert() {
        User roncooUser = new User();
        roncooUser.setName("测试");
        roncooUser.setCreateTime(new Date());
        int result = roncooUserDao.insert(roncooUser);
        System.out.println(result);
    }

    @Test
    public void delete() {
        int result = roncooUserDao.deleteById(1);
        System.out.println(result);
    }

    @Test
    public void update() {
        User roncooUser = new User();
        roncooUser.setId(2);
        roncooUser.setName("测试2");
        roncooUser.setCreateTime(new Date());
        int result = roncooUserDao.updateById(roncooUser);
        System.out.println(result);
    }

    @Test
    public void select() {
        User result = roncooUserDao.selectById(2);
        System.out.println(result);
    }

    @Test
    public void select2() {
        User result = roncooUserDao.selectById(7);
        System.out.println(result);
    }

    // 分页测试
    @Test
    public void queryForPage() {
        Page<User> result = roncooUserDao.queryForPage(1, 20, "测试");
        System.out.println(result.getList());
    }

}
