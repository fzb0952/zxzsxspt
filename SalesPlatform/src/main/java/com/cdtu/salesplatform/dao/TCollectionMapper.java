package com.cdtu.salesplatform.dao;

import com.cdtu.salesplatform.bean.TCollection;

public interface TCollectionMapper {
    int insert(TCollection record);

    int insertSelective(TCollection record);
}