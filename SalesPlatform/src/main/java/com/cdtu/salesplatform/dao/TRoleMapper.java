package com.cdtu.salesplatform.dao;

import com.cdtu.salesplatform.bean.TRole;

public interface TRoleMapper {
    int insert(TRole record);

    int insertSelective(TRole record);
}