package com.chenshun.consumer.util.configuration;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * User: mew <p />
 * Time: 18/4/26 17:46  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Configuration
@RibbonClient(name = "hello-service", configuration = {MyRibbonConfiguration.class})
public class RibbonConfiguration {

}
