package com.taotao.controller;

import com.taotao.content.service.ContentCategoryService;
import com.taotao.pojo.EasyUITreeNode;
import com.taotao.pojo.TaotaoResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Long on 2017/11/8
 * 内容分类管理Controller
 */
@Controller
public class ContentCategoryController {

    @Resource
    private ContentCategoryService contentCategoryService;

    @RequestMapping("/content/category/list")
    @ResponseBody
    public List<EasyUITreeNode> getContentCategoryList(@RequestParam(name = "id", defaultValue = "0") Long parentId) {
        return contentCategoryService.getContentCategoryList(parentId);
    }

    @RequestMapping("content/category/create")
    @ResponseBody
    public TaotaoResult addContentCategory(Long parentId, String name) {
        return contentCategoryService.addContentCategory(parentId, name);
    }

}


