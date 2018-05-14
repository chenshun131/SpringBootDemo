package com.chenshun.test;

import com.chenshun.test.component.MyProps;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * User: mew <p />
 * Time: 18/5/9 15:02  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Test {

    @Autowired
    private MyProps myProps;

    @org.junit.Test
    public void propsTest() {
        System.out.println("simpleProp: " + myProps.getSimpleProp());
    }

}
