package com.taotao.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by Long on 2017/11/2
 * 商品测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/springmvc.xml"})
@WebAppConfiguration
public class ItemControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    /**
     * 测试{@link com.taotao.controller.ItemController#getItemById(Long)}
     *
     * @throws Exception e
     */
    @Test
    public void testGetItem() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/item/536563");
        mockMvc.perform(builder)
                //测试返回状态码是否是200
                .andExpect(MockMvcResultMatchers.status().isOk())
                //测试返回的商品ID是否与请求的一致
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("536563"))
                .andDo(MockMvcResultHandlers.print());
    }


}
