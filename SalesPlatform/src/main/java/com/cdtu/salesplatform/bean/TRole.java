package com.cdtu.salesplatform.bean;

public class TRole {
    private String cBh;

    private String cName;

    private String cZxtmc;

    public String getcBh() {
        return cBh;
    }

    public void setcBh(String cBh) {
        this.cBh = cBh == null ? null : cBh.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcZxtmc() {
        return cZxtmc;
    }

    public void setcZxtmc(String cZxtmc) {
        this.cZxtmc = cZxtmc == null ? null : cZxtmc.trim();
    }
}