package com.cdtu.salesplatform.dao;

import com.cdtu.salesplatform.bean.TNews;

public interface TNewsMapper {
    int insert(TNews record);

    int insertSelective(TNews record);
}