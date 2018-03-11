package com.chenshun.test;

import com.chenshun.test.bean.User;
import com.chenshun.test.component.MongodbComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplication3Tests {

    @Autowired
    private MongodbComponent mongodbComponent;

    @Test
    public void set() {
        User user = new User();
        user.setId(1);
        user.setName("无境1");
        user.setCreateTime(new Date());

        mongodbComponent.insert(user);
    }

    @Test
    public void select() {
        System.out.println(mongodbComponent.selectById(1));
    }

    @Test
    public void update() {
        User user = new User();
        user.setId(1);
        user.setName("测试修改");
        user.setCreateTime(new Date());
        mongodbComponent.updateById(user);
        System.out.println(mongodbComponent.selectById(1));
    }

    @Test
    public void delete() {
        mongodbComponent.deleteById(1);
    }

}
