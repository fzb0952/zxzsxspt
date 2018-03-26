package com.cdtu.salesplatform.bean;

public class TTips {
    private String cBh;

    private String cTip;

    private String cType;

    public String getcBh() {
        return cBh;
    }

    public void setcBh(String cBh) {
        this.cBh = cBh == null ? null : cBh.trim();
    }

    public String getcTip() {
        return cTip;
    }

    public void setcTip(String cTip) {
        this.cTip = cTip == null ? null : cTip.trim();
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType == null ? null : cType.trim();
    }
}