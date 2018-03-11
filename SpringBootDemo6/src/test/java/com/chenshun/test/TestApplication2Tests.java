package com.chenshun.test;

import com.chenshun.test.component.RedisComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * User: mew <p />
 * Time: 18/3/10 17:04  <p />
 * Version: V1.0  <p />
 * Description: 实体类 <p />
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplication2Tests {

    @Autowired
    private RedisComponent redisComponent;

    @Test
    public void set() {
        redisComponent.set("chenshun", "hello world");
    }

    @Test
    public void get() {
        System.out.println(redisComponent.get("chenshun"));
    }

    @Test
    public void del() {
        redisComponent.del("chenshun");
    }

}
