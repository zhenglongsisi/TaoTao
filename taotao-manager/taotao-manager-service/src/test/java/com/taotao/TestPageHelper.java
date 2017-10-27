package com.taotao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Long on 2017/10/27
 */
public class TestPageHelper {


    @Test
    public void testPageHelper() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
        TbItemMapper itemMapper = context.getBean(TbItemMapper.class);
        TbItemExample example = new TbItemExample();
        //设置分页信息
        PageHelper.startPage(1, 30);
        List<TbItem> items = itemMapper.selectByExample(example);
        PageInfo<TbItem> pageInfo = new PageInfo<>(items);
        System.out.println("total：" + pageInfo.getTotal());
        System.out.println("page total" + pageInfo.getPages());
        System.out.println("list size：" + items.size());
    }

}
