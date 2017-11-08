package com.taotao.controller;

import com.taotao.content.service.ContentService;
import com.taotao.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Long on 2017/11/8
 */
@Controller
public class ContentController {

    @Resource
    private ContentService contentService;

    @RequestMapping("/content/save")
    @ResponseBody
    public TaotaoResult addContent(TbContent content) {
        return contentService.addContent(content);
    }

}
