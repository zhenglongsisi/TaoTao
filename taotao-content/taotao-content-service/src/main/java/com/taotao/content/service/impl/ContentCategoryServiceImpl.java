package com.taotao.content.service.impl;

import com.taotao.content.service.ContentCategoryService;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.EasyUITreeNode;
import com.taotao.pojo.TaotaoResult;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Long on 2017/11/8
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

    @Resource
    private TbContentCategoryMapper mapper;

    @SuppressWarnings("Duplicates")
    @Override
    public List<EasyUITreeNode> getContentCategoryList(long parentId) {
        TbContentCategoryExample example = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);

        List<TbContentCategory> categories = mapper.selectByExample(example);
        //转成easyUI需要的json格式数据
        List<EasyUITreeNode> nodes = new ArrayList<>();
        for (TbContentCategory it : categories) {
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(it.getId());
            node.setText(it.getName());
            //如果节点下有子节点“closed”，如果没有子节点“open”
            node.setState(it.getIsParent() ? "closed" : "open");
            nodes.add(node);
        }
        return nodes;
    }

    @Override
    public TaotaoResult addContentCategory(Long parentId, String name) {
        //创建一个pojo对象
        TbContentCategory contentCategory = new TbContentCategory();
        //补全对象的属性
        contentCategory.setParentId(parentId);
        contentCategory.setName(name);
        //状态。可选值:1(正常),2(删除)
        contentCategory.setStatus(1);
        //排序，默认为1
        contentCategory.setSortOrder(1);
        contentCategory.setIsParent(false);
        contentCategory.setCreated(new Date());
        contentCategory.setUpdated(new Date());
        //插入到数据库
        mapper.insert(contentCategory);
        //判断父节点的状态
        TbContentCategory parent = mapper.selectByPrimaryKey(parentId);
        if (!parent.getIsParent()) {
            //如果父节点为叶子节点应该改为父节点
            parent.setIsParent(true);
            //更新父节点
            mapper.updateByPrimaryKey(parent);
        }
        //返回结果
        return TaotaoResult.ok(contentCategory);
    }
}
