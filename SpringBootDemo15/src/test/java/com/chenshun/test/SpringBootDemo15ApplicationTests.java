package com.chenshun.test;

import com.chenshun.test.controller.HelloController;
import com.chenshun.test.service.JdbcService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemo15ApplicationTests {

    @Autowired
    private JdbcService jdbcService;

    @Autowired
    private HelloController helloController;

    private MockMvc mockMvc;

    @Test
    public void contextLoads() {
        jdbcService.dev();
        jdbcService.prod();
    }

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.standaloneSetup(helloController).build();
    }

    @Test
    public void testHellow() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/hello/print").accept(MediaType.APPLICATION_JSON)
                .param("name", "chenshun")
                .param("score", "100"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println("输出 " + mvcResult.getResponse().getContentAsString());
    }

}
