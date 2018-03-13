package com.chenshun.test;

import com.chenshun.test.bean.RoncooUser;
import com.chenshun.test.mapper.RoncooUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemo8ApplicationTests {

    @Autowired
    private RoncooUserMapper userMapper;

    @Test
    public void insert2() {
        RoncooUser user = new RoncooUser();
        user.setName("测试4");
        user.setCreateTime(new Date());
        int result = userMapper.insert(user);
        System.out.println(result);
    }

    @Test
    public void select() {
        RoncooUser user = userMapper.selectByPrimaryKey(4);
        System.out.println(user.toString());
    }

}
