package com.tingyu.service;

import com.tingyu.domain.userinfo.TAdmin;

/**
 * Created by tingyu on 2017/2/21.
 */
public interface ILoginService {
    TAdmin getAdminByUsernameAndPassword(String username, String password);
}
