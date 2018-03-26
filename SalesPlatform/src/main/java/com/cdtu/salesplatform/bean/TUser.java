package com.cdtu.salesplatform.bean;

public class TUser {
    private String cBh;

    private String cUsername;

    private String cPasswprd;

    private Integer nAge;

    private String cSex;

    private String cTel;

    private String cAdress;

    private String cEmail;

    private String cOrder;

    private String cCar;

    private String cCollectrion;

    public String getcBh() {
        return cBh;
    }

    public void setcBh(String cBh) {
        this.cBh = cBh == null ? null : cBh.trim();
    }

    public String getcUsername() {
        return cUsername;
    }

    public void setcUsername(String cUsername) {
        this.cUsername = cUsername == null ? null : cUsername.trim();
    }

    public String getcPasswprd() {
        return cPasswprd;
    }

    public void setcPasswprd(String cPasswprd) {
        this.cPasswprd = cPasswprd == null ? null : cPasswprd.trim();
    }

    public Integer getnAge() {
        return nAge;
    }

    public void setnAge(Integer nAge) {
        this.nAge = nAge;
    }

    public String getcSex() {
        return cSex;
    }

    public void setcSex(String cSex) {
        this.cSex = cSex == null ? null : cSex.trim();
    }

    public String getcTel() {
        return cTel;
    }

    public void setcTel(String cTel) {
        this.cTel = cTel == null ? null : cTel.trim();
    }

    public String getcAdress() {
        return cAdress;
    }

    public void setcAdress(String cAdress) {
        this.cAdress = cAdress == null ? null : cAdress.trim();
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail == null ? null : cEmail.trim();
    }

    public String getcOrder() {
        return cOrder;
    }

    public void setcOrder(String cOrder) {
        this.cOrder = cOrder == null ? null : cOrder.trim();
    }

    public String getcCar() {
        return cCar;
    }

    public void setcCar(String cCar) {
        this.cCar = cCar == null ? null : cCar.trim();
    }

    public String getcCollectrion() {
        return cCollectrion;
    }

    public void setcCollectrion(String cCollectrion) {
        this.cCollectrion = cCollectrion == null ? null : cCollectrion.trim();
    }
}