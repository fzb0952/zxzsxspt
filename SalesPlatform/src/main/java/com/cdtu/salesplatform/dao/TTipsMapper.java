package com.cdtu.salesplatform.dao;

import com.cdtu.salesplatform.bean.TTips;

public interface TTipsMapper {
    int insert(TTips record);

    int insertSelective(TTips record);
}