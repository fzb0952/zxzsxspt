package com.tingyu.service.impl;

import com.tingyu.dao.userinfo.TAdminMapper;
import com.tingyu.domain.userinfo.TAdmin;
import com.tingyu.service.ILoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Created by tingyu on 2017/2/21.
 */
@Service
public class LoginServiceImpl implements ILoginService {

    @Resource
    private TAdminMapper tAdminMapper;

    @Override
    public TAdmin getAdminByUsernameAndPassword(String username, String password) {
        return tAdminMapper.selectByUsernameAndPassword(username,password);
    }
}
