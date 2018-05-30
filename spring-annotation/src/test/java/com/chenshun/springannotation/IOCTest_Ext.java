package com.chenshun.springannotation;

import com.chenshun.springannotation.ext.ExtConfig;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Ext {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);
        //发布事件；
        applicationContext.publishEvent(new ApplicationEvent("我发布的时间") {
            private static final long serialVersionUID = 3501114030920967369L;
        });
        applicationContext.close();
    }

}
