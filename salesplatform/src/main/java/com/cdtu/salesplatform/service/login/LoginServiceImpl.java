package com.cdtu.salesplatform.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdtu.salesplatform.constant.BaseConstant;
import com.cdtu.salesplatform.dao.TUserMapper;
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    TUserMapper tUserMapper;

    @Override
    public String login(String userName, String passWord) {
        if (tUserMapper.searchUser(userName, passWord) == null) {
            return BaseConstant.FALSE;
        }
        else{
            return BaseConstant.TRUE;
        }
    }

}
