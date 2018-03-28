package com.cdtu.salesplatform.dao;

import com.cdtu.salesplatform.bean.TGoods;

public interface TGoodsMapper {
    int insert(TGoods record);

    int insertSelective(TGoods record);
}