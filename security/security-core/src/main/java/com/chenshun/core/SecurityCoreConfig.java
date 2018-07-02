package com.chenshun.core;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * User: chenshun131 <p />
 * Time: 18/6/24 14:36  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {

}
