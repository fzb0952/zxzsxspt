package com.cdtu.salesplatform.dao;

import org.apache.ibatis.annotations.Param;

import com.cdtu.salesplatform.bean.TUser;

public interface TUserMapper {
    int insert(TUser record);

    int insertSelective(TUser record);
    
    TUser searchUser(@Param("userName")String userName,@Param("passWord")String passWord);
}