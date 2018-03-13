package com.chenshun.test;

import com.chenshun.test.bean.RoncooUser;
import com.chenshun.test.bean.User;
import com.chenshun.test.mapper.RoncooUserMapper;
import com.chenshun.test.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemo7ApplicationTests3 {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private RoncooUserMapper roncooUserMapper;

    @Test
    public void insert() {
        User user = new User();
        user.setName("测试");
        user.setCreateTime(new Date());
        int result = mapper.insert(user);
        System.out.println(result);
    }

    @Test
    public void insert2() {
        RoncooUser roncooUser = new RoncooUser();
        roncooUser.setName("测试2");
        roncooUser.setCreateTime(new Date());
        int result = roncooUserMapper.insert(roncooUser);
        System.out.println(result);
    }

    @Test
    public void select() {
        RoncooUser roncooUser = roncooUserMapper.selectByPrimaryKey(2);
        System.out.println(roncooUser.toString());
    }

}
