package com.itheima.springboot_13_configuration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

@SpringBootTest(properties = "test.testvalue",
        args = "--test.prop=testval",
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//开启虚拟MVC调用
@AutoConfigureMockMvc
class Springboot13ConfigurationApplicationTests {

    @Value("test.prop")
    private String value;

    @Test
    void contextLoads() {
    }

    @Test
    void testWeb(@Autowired MockMvc mvc) throws Exception{
        //创建虚拟请求
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions action = mvc.perform(builder);

        //定义本次调用预期值
        StatusResultMatchers status = MockMvcResultMatchers.status();
        ResultMatcher matcher = status.isOk();
        //将预期与结果比对
        action.andExpect(matcher);

        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher contentMatcher = content.json("{\"id\":1,\"name\":\"chs\"}");
        action.andExpect(contentMatcher);

    }

}
