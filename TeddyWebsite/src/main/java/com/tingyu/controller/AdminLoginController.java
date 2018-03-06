package com.tingyu.controller;

import com.tingyu.common.ICommonConstants;
import com.tingyu.domain.userinfo.TAdmin;
import com.tingyu.service.impl.LoginServiceImpl;
import com.tingyu.utils.ParamUtil;
import com.tingyu.utils.SessionUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tingyu on 2017/4/3.
 */
@RequestMapping("admin")
@Controller
public class AdminLoginController {

    private Log log = LogFactory.getLog(AdminLoginController.class);

    @Autowired
    private LoginServiceImpl loginService;

    /**
     *  Admin Login.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping("login")
    public String Login(Model model){
        String username = ParamUtil.getString("username");
        String password = ParamUtil.getString("password");

        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)){
            model.addAttribute(ICommonConstants.C_ERROR,"username or password is null,please check!");
            return "forward:/admin";
        }
        TAdmin admin = loginService.getAdminByUsernameAndPassword(username,password);
        if(null == admin){
            model.addAttribute(ICommonConstants.C_ERROR,"username or password is wrong,please check!");
            model.addAttribute("username",username);
            model.addAttribute("password",username);
            return "forward:/admin";
        }
        // 登录成功后将其放入session中
        SessionUtil.setAdmin(admin);
        return "redirect:/admin/index";
    }


    /**
     * Logout.
     *
     * @return the string
     */
    @RequestMapping("logout")
    public String logout(){
        // 注销时清除session
        SessionUtil.clearAdmin();
        return "redirect:/admin";
    }
}
