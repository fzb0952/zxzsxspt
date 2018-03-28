package com.cdtu.salesplatform.dao;

import com.cdtu.salesplatform.bean.TUserRole;

public interface TUserRoleMapper {
    int insert(TUserRole record);

    int insertSelective(TUserRole record);
}