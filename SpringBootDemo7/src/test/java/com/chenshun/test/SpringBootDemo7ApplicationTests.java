package com.chenshun.test;

import com.chenshun.test.component.JmsComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemo7ApplicationTests {

    @Autowired
    private JmsComponent jmsComponent;

    @Test
    public void send() {
        jmsComponent.send("hello world");
    }

}
