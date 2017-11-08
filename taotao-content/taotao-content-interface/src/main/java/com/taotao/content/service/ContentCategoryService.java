package com.taotao.content.service;

import com.taotao.pojo.EasyUITreeNode;
import com.taotao.pojo.TaotaoResult;

import java.util.List;

/**
 * Created by Long on 2017/11/8
 */
public interface ContentCategoryService {

    List<EasyUITreeNode> getContentCategoryList(long parentId);


    TaotaoResult addContentCategory(Long parentId, String name);

}
