package com.cdtu.salesplatform.dao;

import com.cdtu.salesplatform.bean.TCar;

public interface TCarMapper {
    int insert(TCar record);

    int insertSelective(TCar record);
}