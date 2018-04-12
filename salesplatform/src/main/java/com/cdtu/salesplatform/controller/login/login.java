package com.cdtu.salesplatform.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdtu.salesplatform.service.login.LoginService;

@Controller
public class login {
    @Autowired
    LoginService loginService;
    @RequestMapping("/loginController")
    @ResponseBody
    public String loginController(@RequestParam("username") String userName,@RequestParam("password") String passWord){
        
        return loginService.login(userName, passWord);
    }
}
