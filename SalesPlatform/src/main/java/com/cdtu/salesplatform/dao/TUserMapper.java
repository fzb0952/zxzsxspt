package com.cdtu.salesplatform.dao;

import com.cdtu.salesplatform.bean.TUser;

public interface TUserMapper {
    int insert(TUser record);

    int insertSelective(TUser record);
}