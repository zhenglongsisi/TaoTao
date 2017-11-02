package com.taotao.test;

import com.taotao.controller.TestController;
import com.taotao.utils.JsonUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by Long on 2017/11/2
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/springmvc.xml"})
@WebAppConfiguration
public class CommonTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testRequestJson() throws Exception {
        TestController.JsonEntity entity = new TestController.JsonEntity();
        entity.setId(888);
        entity.setTitle("This is a Title!");
        String json = JsonUtils.objectToJson(entity);
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/test/json")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(json);
        mockMvc.perform(builder)
                .andDo(MockMvcResultHandlers.print());
    }

}
