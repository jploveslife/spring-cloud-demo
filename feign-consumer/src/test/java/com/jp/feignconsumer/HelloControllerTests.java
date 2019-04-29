package com.jp.feignconsumer;

import com.jp.feignconsumer.controller.HelloController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


/**
 * @Author: jipeng
 * @Description:
 * @Date: Created in 2019/4/24 8:08
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = FeignConsumerApplication.class)
public class HelloControllerTests {

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception{
        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @Test
    public void hello() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/hello")
//                .accept(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(status().isOk())
//                .andExpect(content().string(equalTo("Hello World")));
    }



}
