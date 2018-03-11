package com.chenshun.test;

import com.chenshun.test.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * User: chenshun131 <p />
 * Time: 18/3/10 15:45  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests2 {

    @Autowired
    private UserService userService;

    @Test
    public void register() {
        String result = userService.register("无境ff", "192.168.1.1");
        System.out.println(result);
    }

}
