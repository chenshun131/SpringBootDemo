package com.chenshun.springbootdemo19.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * User: chenshun131 <p />
 * Time: 18/7/2 22:12  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Slf4j
@Order(value = 1)
@Component
public class MyStartupRunner1 implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.debug(">>>>>>>>>>>>>>> 服务启动执行，执行加载数据等操作 <<<<<<<<<<<<<<<");
    }

}
