package com.cdtu.salesplatform.dao;

import com.cdtu.salesplatform.bean.TOrder;

public interface TOrderMapper {
    int insert(TOrder record);

    int insertSelective(TOrder record);
}