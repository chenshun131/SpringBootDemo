package com.chenshun.test.component;

import org.springframework.stereotype.Component;

/**
 * User: mew <p />
 * Time: 18/3/12 14:12 <p />
 * Version: V1.0  <p />
 * Description: RabbitMQ <p />
 */
@Component
public class AmqpComponent {

//    @Autowired
//    private AmqpTemplate amqpTemplate;

    public void send(String msg) {
//        amqpTemplate.convertAndSend("chenshun.queue", msg);
    }

//    @RabbitListener(queues = "chenshun.queue")
    public void receiveQueue(String text) {
        System.out.println("接受到：" + text);
    }

}
