package com.taotao.service;

import com.taotao.pojo.EasyUIDataGridResult;
import com.taotao.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

/**
 * Created by Long on 2017/10/26
 */
public interface ItemService {

    TbItem getItemById(long itemId);

    EasyUIDataGridResult getItemList(int pageNum, int pageSize);

    TaotaoResult addItem(TbItem item, String desc);

}
