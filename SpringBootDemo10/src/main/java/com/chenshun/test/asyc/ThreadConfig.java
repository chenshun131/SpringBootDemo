package com.chenshun.test.asyc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * User: mew <p />
 * Time: 18/3/27 16:55  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Configuration
@ComponentScan("com.chenshun.test.service")
public class ThreadConfig {

    /**
     * 执行需要依赖线程池，这里就来配置一个线程池
     *
     * @return
     */
    @Bean
    public Executor getExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(25);
        executor.initialize();

        return executor;
    }

}
