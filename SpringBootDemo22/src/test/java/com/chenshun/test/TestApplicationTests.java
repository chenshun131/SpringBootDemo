package com.chenshun.test;

import com.chenshun.test.collection.Results;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {

    @Autowired
    private Results results;

    @Test
    public void contextLoads() {
        // [RankOne, RankThree, RankTwo]
        System.out.println(results.toString());

        // [RankOne, RankTwo, RankThree]
    }

}
