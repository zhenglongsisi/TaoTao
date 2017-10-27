package com.taotao.service;

import com.taotao.pojo.EasyUITreeNode;

import java.util.List;

/**
 * Created by Long on 2017/10/27
 */
public interface ItemCatService {

    List<EasyUITreeNode> getItemCatList(long parentId);

}
