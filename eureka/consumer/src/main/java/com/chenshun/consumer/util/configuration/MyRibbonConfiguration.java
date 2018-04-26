package com.chenshun.consumer.util.configuration;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * User: mew <p />
 * Time: 18/4/26 17:24  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Configuration
public class MyRibbonConfiguration {

    @Bean
    public IPing ribbonPing() {
        return new PingUrl();
    }

}
