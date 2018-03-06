package com.tingyu.controller;

import com.tingyu.bean.mail.MailInfo;
import com.tingyu.common.ICommonConstants;
import com.tingyu.service.IMailService;
import com.tingyu.utils.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 处理邮件发送相关的Controller
 * Created by tingyu on 2017/3/16.
 */
@Controller
@RequestMapping("mail")
public class MailController {
    @Autowired
    private IMailService mailService;

    @RequestMapping("contactMe")
    @ResponseBody
    public void sendContactMeMail(){
        Map<String,Object> result = new HashMap<>(0);
        MailInfo mailInfo = (MailInfo) ParamUtil.getBean(MailInfo.class,"mailInfo");

        if(null == mailInfo){
            result.put(ICommonConstants.C_ERROR,"邮件发送失败，请检查信息是否完整！");
            ParamUtil.setAttributes(result);
            return;
        }

        mailInfo.setToReplyAddress(ParamUtil.getString("contacterAddress"));

        mailService.sendContactMeMail(mailInfo,result);
        ParamUtil.setAttributes(result);
    }
}
