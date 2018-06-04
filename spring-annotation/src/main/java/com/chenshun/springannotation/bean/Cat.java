package com.chenshun.springannotation.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Cat implements InitializingBean, DisposableBean {

    public Cat() {
        System.out.println("cat constructor...");
    }

    /**
     * 定义初始化逻辑
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat...afterPropertiesSet...");
    }

    /**
     * 定义销毁逻辑
     *
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("cat...destroy...");
    }

}
