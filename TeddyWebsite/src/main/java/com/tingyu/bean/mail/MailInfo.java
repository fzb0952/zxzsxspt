package com.tingyu.bean.mail;

import java.io.File;
import java.util.Map;

/**
 * 保存邮件发送时的各种参数
 * Created by tingyu on 2017/3/16.
 */
public class MailInfo {
    /**
     * 发件人
     **/
    private String fromAddress;

    /**
     * 发件人昵称
     */
    private String fromNick;

    /**
     * 收件人
     **/
    private String[] toAddress;

    /**
     * 邮件回复地址

     */
    private String toReplyAddress;

    /**
     * 抄送人
     */
    private String[] copyToAddress;

    /**
     * 邮件主题
     **/
    private String subject;

    /**
     * 邮件内容
     * "<img src=\"cid:aaa\"/>插入图片  imgMap = <cid,fileName>
     **/
    private String content;

    /** 附件信息 -- images */
    private Map<String,String> imgMap;

    /** 附件信息 */
    private String[] attachmentFiles;

    public Map<String, String> getImgMap() {
        return imgMap;
    }

    public void setImgMap(Map<String, String> imgMap) {
        this.imgMap = imgMap;
    }

    public String[] getAttachmentFiles() {
        return attachmentFiles;
    }

    public void setAttachmentFiles(String[] attachmentFiles) {
        this.attachmentFiles = attachmentFiles;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String[] getToAddress() {
        return toAddress;
    }

    public void setToAddress(String[] toAddress) {
        this.toAddress = toAddress;
    }

    public String[] getCopyToAddress() {
        return copyToAddress;
    }

    public void setCopyToAddress(String[] copyToAddress) {
        this.copyToAddress = copyToAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getToReplyAddress() {
        return toReplyAddress;
    }

    public void setToReplyAddress(String toReplyAddress) {
        this.toReplyAddress = toReplyAddress;
    }

    public String getFromNick() {
        return fromNick;
    }

    public void setFromNick(String fromNick) {
        this.fromNick = fromNick;
    }
}
