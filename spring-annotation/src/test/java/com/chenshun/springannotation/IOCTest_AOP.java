package com.chenshun.springannotation;

import com.chenshun.springannotation.aop.MathCalculator;
import com.chenshun.springannotation.config.MainConfigOfAOP;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_AOP {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);

        //1、不要自己创建对象
//		MathCalculator mathCalculator = new MathCalculator();
//		mathCalculator.div(1, 1);
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);

        mathCalculator.div(1, 0);

        applicationContext.close();
    }

}
