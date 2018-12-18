package cn.mxa.ssm.service;

import cn.mxa.ssm.po.ItemsCustom;
import cn.mxa.ssm.po.itemsQueryVo;

import java.util.List;

/**
 * 商品管理service
 * @author maoxuanang
 */
public interface ItemsService {
    public List<ItemsCustom> findItemsList(itemsQueryVo itemsQueryVo)throws Exception;

    public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception;

    public ItemsCustom findAllByid(Integer id) throws  Exception;
}
