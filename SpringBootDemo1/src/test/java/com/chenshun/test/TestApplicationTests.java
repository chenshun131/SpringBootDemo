package com.chenshun.test;

import com.chenshun.test.controller.IndexController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {

    private MockMvc mvc;

    @Before
    public void setup() {
        this.mvc = MockMvcBuilders.standaloneSetup(new IndexController()).build();
    }

    @Test
    public void contextLoads() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/index");
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("hello world"));

        request = MockMvcRequestBuilders.get("/index/get").param("name", "无境");
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("{\"name\":\"无境\",\"title\":\"hello world\"}"));
    }

}
