package com.chenshun.test.component;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * User: chenshun131 <p />
 * Time: 18/7/2 22:12  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Order(value = 2)
@Component
public class MyStartupRunner2 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>> 服务启动执行，执行加载数据等操作222222 <<<<<<<<<<<<<<<");
    }

}
