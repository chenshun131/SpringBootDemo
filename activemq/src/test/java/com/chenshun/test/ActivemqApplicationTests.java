package com.chenshun.test;

import com.chenshun.test.bean.Mail;
import com.chenshun.test.service.MQProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivemqApplicationTests {

    @Autowired
    private MQProducer mqProducer;

    @Test
    public void send() {
        Mail mail = new Mail();
        mail.setTo("174754613@qq.com");
        mail.setSubject("异步发送邮件");
        mail.setContent("Hi,This is a message!");

        this.mqProducer.sendMessage(mail);
        System.out.println("发送成功..");
    }

}
