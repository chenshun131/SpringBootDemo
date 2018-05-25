package com.chenshun.configserverrabbit;

import com.chenshun.configserverrabbit.bean.Order;
import com.chenshun.configserverrabbit.message.RabbitSender;
import com.chenshun.configserverrabbit.message.SendMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigServerRabbitApplicationTests {

    @Autowired
    private RabbitSender rabbitSender;

    @Test
    public void contextLoads() {
        rabbitSender.send("myQueue", "测试数据");
    }

    @Test
    public void sendOrder() {
        rabbitSender.send("myOrder", "computer", "测试数据");
        rabbitSender.send("myOrder", "fruit", "测试数据");
    }

    @Autowired
    private SendMessage sendMessage;

    @Test
    public void sendOrder2() {
        Order order = new Order();
        order.setId(1L);
        order.setName("订单'");
        order.setCount(10);
        sendMessage.send(order);
    }

}
