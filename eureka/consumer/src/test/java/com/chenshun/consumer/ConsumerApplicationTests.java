package com.chenshun.consumer;

import com.chenshun.consumer.controller.ConsumerController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private ConsumerController consumerController;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.standaloneSetup(consumerController).build();
    }

    @Test
    public void user5() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/user5"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println("输出 " + mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void user6() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user6"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void user7() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user7"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

}
