package cn.mxa.ssm.mapper;

import cn.mxa.ssm.po.ItemsCustom;
import cn.mxa.ssm.po.itemsQueryVo;

import java.util.List;

public interface ItemsMapperCustom {
    public List<ItemsCustom> findItemsList(itemsQueryVo itemsQueryVo)throws Exception;
}
