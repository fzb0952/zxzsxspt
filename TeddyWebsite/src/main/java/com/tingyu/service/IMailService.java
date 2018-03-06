package com.tingyu.service;

import com.tingyu.bean.mail.MailInfo;

import java.util.Map;

/**
 * Created by tingyu on 2017/3/17.
 */
public interface IMailService {


    /**
     * Send contact me mail.
     * 邮件发送成功后，给联系人立即回复一封邮件
     * @param mailInfo the mail info
     * @param result   the result
     */
    void sendContactMeMail(MailInfo mailInfo, Map<String,Object> result);
}
