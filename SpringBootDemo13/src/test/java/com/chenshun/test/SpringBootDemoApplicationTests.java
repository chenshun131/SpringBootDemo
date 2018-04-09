package com.chenshun.test;

import com.chenshun.test.bean.A;
import com.chenshun.test.mapper.AMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTests {

    @Autowired
    private AMapper aMapper;

    @Test
    public void contextLoads() {
        List<A> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(new A("a" + i));
        }
        aMapper.insert(list);
    }

}
