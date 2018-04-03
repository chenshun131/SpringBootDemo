package com.chenshun.test;

import com.chenshun.test.service.JdbcService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemo12ApplicationTests {

    @Autowired
    private JdbcService jdbcService;

    @Test
    public void test1() {
        jdbcService.printCommon();
    }

    @Test
    public void test2() {
        jdbcService.printDataFromMultiDatabaseData();
    }

}
