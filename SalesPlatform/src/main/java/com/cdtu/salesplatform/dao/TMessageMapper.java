package com.cdtu.salesplatform.dao;

import com.cdtu.salesplatform.bean.TMessage;

public interface TMessageMapper {
    int insert(TMessage record);

    int insertSelective(TMessage record);
}