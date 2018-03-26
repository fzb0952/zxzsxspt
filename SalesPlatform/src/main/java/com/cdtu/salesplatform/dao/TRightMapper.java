package com.cdtu.salesplatform.dao;

import com.cdtu.salesplatform.bean.TRight;

public interface TRightMapper {
    int insert(TRight record);

    int insertSelective(TRight record);
}