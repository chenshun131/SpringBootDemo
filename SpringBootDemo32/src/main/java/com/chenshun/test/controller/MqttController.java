package com.chenshun.test.controller;

import com.chenshun.test.mqtt.MqttPushClient;
import com.chenshun.test.mqtt.PushPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: chenshun131 <p />
 * Time: 18/10/7 21:20  <p />
 * Version: V1.0  <p />
 * Description: />
 */
@RestController
public class MqttController {

    @Autowired
    private MqttPushClient mqttPushClient;

    @RequestMapping("/hello")
    public String sendHello() {
        String kdTopic = "topic1";
        PushPayload pushPayload = PushPayload.getPushPayloadBuider()
                .setContent("content")
                .setTitle("title")
                .setMobile("15623459526")
                .setBadge(123456)
                .setSound("sound")
                .setType("type").bulid();
        mqttPushClient.publish(0, false, kdTopic, pushPayload);
        mqttPushClient.subscribe(kdTopic);
        return "123";
    }

}
