package com.tingyu.service.impl;

import com.tingyu.bean.mail.MailInfo;
import com.tingyu.common.ICommonConstants;
import com.tingyu.service.IMailService;
import com.tingyu.utils.MailUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by tingyu on 2017/3/17.
 */
@Service
public class MailServiceImpl implements IMailService {
    private Log log = LogFactory.getLog(MailServiceImpl.class);
    /**
     * Send contact me mail.
     * 邮件发送成功后，给联系人立即回复一封邮件
     *
     * @param mailInfo the mail info
     * @param result   the result
     */
    @Override
    public void sendContactMeMail(MailInfo mailInfo, Map<String, Object> result) {
        if (MailUtil.sendHtmlMail(mailInfo)) {
            MailInfo replyMailInfo = new MailInfo();
            replyMailInfo.setToAddress(new String[]{mailInfo.getToReplyAddress()});
            replyMailInfo.setFromNick("范中伟");
            replyMailInfo.setFromAddress(mailInfo.getToAddress()[0]);
            replyMailInfo.setToReplyAddress(mailInfo.getToAddress()[0]);
            replyMailInfo.setSubject("感谢您的来信");
            replyMailInfo.setContent("我已收到您的来信，我将尽快与您联系，谢谢！");

            if(!MailUtil.sendHtmlMail(replyMailInfo)){
                log.error("回复邮件失败，邮件地址为：" + mailInfo.getToReplyAddress());
                result.put(ICommonConstants.C_ERROR, "邮件发送失败，请检查地址是否正确！");
            }else{
                result.put(ICommonConstants.C_SUCCESS, "邮件发送成功！");
            }

            // TODO   将邮件发送记录写入数据，以后由后台进行维护
        } else {
            result.put(ICommonConstants.C_ERROR, "邮件发送失败，请检查地址是否正确！");
        }
    }
}
