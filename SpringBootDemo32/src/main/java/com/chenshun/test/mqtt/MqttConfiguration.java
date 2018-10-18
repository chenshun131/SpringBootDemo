package com.chenshun.test.mqtt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * User: chenshun131 <p />
 * Time: 18/10/7 21:09  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Data
@Component
@Configuration
@ConfigurationProperties(prefix = "mqtt")
public class MqttConfiguration {

    private String host;

    private String clientid;

    private String username;

    private String password;

    private int timeout;

    private int keepalive;

    @Bean
    public MqttPushClient getMqttPushClient() {
        MqttPushClient mqttPushClient = new MqttPushClient();
        mqttPushClient.connect(host, clientid, username, password, timeout, keepalive);
        return mqttPushClient;
    }

}
