package com.cdtu.salesplatform.bean;

import java.util.Date;

public class TNews {
    private String cBh;

    private String cNew;

    private Date dAdddate;

    public String getcBh() {
        return cBh;
    }

    public void setcBh(String cBh) {
        this.cBh = cBh == null ? null : cBh.trim();
    }

    public String getcNew() {
        return cNew;
    }

    public void setcNew(String cNew) {
        this.cNew = cNew == null ? null : cNew.trim();
    }

    public Date getdAdddate() {
        return dAdddate;
    }

    public void setdAdddate(Date dAdddate) {
        this.dAdddate = dAdddate;
    }
}