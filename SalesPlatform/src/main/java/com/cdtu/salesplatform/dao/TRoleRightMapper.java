package com.cdtu.salesplatform.dao;

import com.cdtu.salesplatform.bean.TRoleRight;

public interface TRoleRightMapper {
    int insert(TRoleRight record);

    int insertSelective(TRoleRight record);
}