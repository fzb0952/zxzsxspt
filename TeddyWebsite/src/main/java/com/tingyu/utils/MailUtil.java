package com.tingyu.utils;

import com.tingyu.bean.mail.MailInfo;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;

/**
 * 基于spring mail 封装邮件发送相关方法
 * Created by tingyu on 2017/3/16.
 */
public class MailUtil {
    private static Log log = LogFactory.getLog(MailUtil.class);
    private static JavaMailSenderImpl mailSender = (JavaMailSenderImpl) SpringUtil.getBean("mailSender");
    private static ThreadPoolTaskExecutor taskExecutor = (ThreadPoolTaskExecutor) SpringUtil.getBean("taskExecutor");

    /**
     * Send simple mail boolean.
     *
     * @param mailInfo the mail info
     * @return the boolean
     */
    public static boolean sendSimpleMail(MailInfo mailInfo) {
        if (null == mailInfo || null == mailInfo.getToAddress()) {
            return false;
        }
        // 建立邮件消息
        SimpleMailMessage mailMessage = buildSimpleMailMessage(mailInfo);
        // 收件人数量大于5时采用异步发送
        if (mailInfo.getToAddress().length > 5) {
            sendMailByAsynchronousMode(mailMessage);
        } else {
            return sendMailBySynchronizationMode(mailMessage);
        }
        return true;
    }

    /**
     * Send html mail boolean.
     *
     * @param mailInfo the mail info
     * @return the boolean
     */
    public static boolean sendHtmlMail(MailInfo mailInfo) {
        if (null == mailInfo || null == mailInfo.getToAddress()) {
            return false;
        }
        MimeMessage mailMessage = buildHtmlMailMessage(mailInfo);
        // 收件人数量大于5时采用异步发送
        if (mailInfo.getToAddress().length > 5) {
            sendMailByAsynchronousMode(mailMessage);
        } else {
            return sendMailBySynchronizationMode(mailMessage);
        }
        return true;
    }

    /**
     * 构建HTML Message
     * @param mailInfo
     * @return MimeMessage
     */
    private static MimeMessage buildHtmlMailMessage(MailInfo mailInfo) {
        // 建立邮件消息,发送简单邮件和html邮件的区别
        MimeMessage mailMessage = mailSender.createMimeMessage();
        // 注意这里的boolean,等于真的时候才能嵌套图片，在构建MimeMessageHelper时候，所给定的值是true表示启用，
        // multipart模式
        MimeMessageHelper messageHelper = null;
        try {
            messageHelper = new MimeMessageHelper(mailMessage, true,"UTF-8");
            String fromAddress = mailInfo.getFromAddress();
            if(StringUtils.isBlank(fromAddress)){
                fromAddress = mailSender.getUsername();
            }
            if (StringUtils.isNotBlank(mailInfo.getFromNick())){
                messageHelper.setFrom(fromAddress,mailInfo.getFromNick()); // 设置带有昵称的发件人地址
            }else{
                messageHelper.setFrom(fromAddress);     // 设置发件人地址
            }
            messageHelper.setReplyTo(fromAddress);  // 设置回复地址
            messageHelper.setTo(mailInfo.getToAddress());         // 设置收件人地址
            if(null != mailInfo.getCopyToAddress() && mailInfo.getCopyToAddress().length > 0){
                messageHelper.setCc(mailInfo.getCopyToAddress());     // 设置邮件抄送者
            }
            messageHelper.setSubject(mailInfo.getSubject());      // 设置邮件主题
            messageHelper.setText(mailInfo.getContent(), true);         // 设置邮件内容 "<img src=\"cid:aaa\"/>插入图片
            // 添加图片信息
            if (null != mailInfo.getImgMap() && !mailInfo.getImgMap().isEmpty()) {
                FileSystemResource img = null;
                for (Map.Entry<String, String> imgMapEntry : mailInfo.getImgMap().entrySet()) {
                    img = new FileSystemResource(new File(imgMapEntry.getValue()));
                    messageHelper.addInline(imgMapEntry.getKey(), img);
                }
            }

            // 添加附件信息
            if(null != mailInfo.getAttachmentFiles() && mailInfo.getAttachmentFiles().length > 0){
                File file = null;
                for(String fileName : mailInfo.getAttachmentFiles()){
                    file = new File(fileName);
                    messageHelper.addAttachment(file.getName(),file);
                }
            }
        } catch (Exception e) {
            log.error("构建MimeMessageHelper失败", e);
        }
        return mailMessage;
    }

    /**
     * 构建简单邮件message
     *
     * @param mailInfo
     * @return SimpleMailMessage
     */
    private static SimpleMailMessage buildSimpleMailMessage(MailInfo mailInfo) {
        // 建立邮件消息
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        String fromAddress = mailInfo.getFromAddress();
        if(StringUtils.isBlank(fromAddress)){
            fromAddress = mailSender.getUsername();
        }
        mailMessage.setFrom(fromAddress);     // 设置发件人地址
        mailMessage.setReplyTo(mailInfo.getToReplyAddress());  // 设置回复地址
        mailMessage.setTo(mailInfo.getToAddress());         // 设置收件人地址
        if(null != mailInfo.getCopyToAddress() && mailInfo.getCopyToAddress().length > 0) {
            mailMessage.setCc(mailInfo.getCopyToAddress());     // 设置邮件抄送者
        }
        mailMessage.setSubject(mailInfo.getSubject());      // 设置邮件主题
        mailMessage.setText(mailInfo.getContent());         // 设置邮件内容
        return mailMessage;
    }

    /**
     * 同步发送邮件 MimeMessage
     *
     * @param mailMessage
     * @return
     */
    private static boolean sendMailBySynchronizationMode(MimeMessage mailMessage) {
        try {
            mailSender.send(mailMessage);
        } catch (Exception e) {
            log.error("同步发送邮件失败", e);
            return false;
        }
        return true;
    }

    /**
     * 异步发送邮件 MimeMessage
     *
     * @param mailMessage
     */
    private static void sendMailByAsynchronousMode(MimeMessage mailMessage) {
        taskExecutor.execute(new Runnable() {
            public void run() {
                try {
                    sendMailBySynchronizationMode(mailMessage);
                } catch (Exception e) {
                    log.error("异步邮件发送失败", e);
                }
            }
        });
    }

    /**
     * 同步发送邮件 SimpleMailMessage
     *
     * @param mailMessage
     * @return
     */
    private static boolean sendMailBySynchronizationMode(SimpleMailMessage mailMessage) {
        try {
            mailSender.send(mailMessage);
        } catch (Exception e) {
            log.error("同步发送邮件失败", e);
            return false;
        }
        return true;
    }

    /**
     * 异步发送邮件 SimpleMailMessage
     *
     * @param mailMessage
     */
    private static void sendMailByAsynchronousMode(SimpleMailMessage mailMessage) {
        taskExecutor.execute(new Runnable() {
            public void run() {
                try {
                    sendMailBySynchronizationMode(mailMessage);
                } catch (Exception e) {
                    log.error("异步邮件发送失败", e);
                }
            }
        });
    }

}
