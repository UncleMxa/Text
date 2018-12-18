package cn.mxa.ssm.service.impl;

import cn.mxa.ssm.mapper.ItemsMapper;
import cn.mxa.ssm.mapper.ItemsMapperCustom;
import cn.mxa.ssm.po.Items;
import cn.mxa.ssm.po.ItemsCustom;
import cn.mxa.ssm.po.itemsQueryVo;
import cn.mxa.ssm.service.ItemsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsMapperCustom itemsMapperCustom;

    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<ItemsCustom> findItemsList(itemsQueryVo itemsQueryVo) throws Exception {
        return itemsMapperCustom.findItemsList(itemsQueryVo);
    }

    @Override
    public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
        itemsCustom.setId(id);
        itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
    }

    @Override
    public ItemsCustom findAllByid(Integer id) throws Exception {
        Items items = itemsMapper.selectByPrimaryKey(id);
        ItemsCustom itemsCustom = new ItemsCustom();
        BeanUtils.copyProperties(items,itemsCustom);
        return itemsCustom;
    }
}
