package com.cdtu.salesplatform.bean;

import java.util.Date;

public class TMessage {
    private String cBh;

    private String cMessage;

    private Date dAdddate;

    private String cName;

    public String getcBh() {
        return cBh;
    }

    public void setcBh(String cBh) {
        this.cBh = cBh == null ? null : cBh.trim();
    }

    public String getcMessage() {
        return cMessage;
    }

    public void setcMessage(String cMessage) {
        this.cMessage = cMessage == null ? null : cMessage.trim();
    }

    public Date getdAdddate() {
        return dAdddate;
    }

    public void setdAdddate(Date dAdddate) {
        this.dAdddate = dAdddate;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }
}