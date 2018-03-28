package com.cdtu.salesplatform.bean;

public class TOrder {
    private String cBh;

    private Integer nNum;

    private String cGoods;

    private String cPay;

    public String getcBh() {
        return cBh;
    }

    public void setcBh(String cBh) {
        this.cBh = cBh == null ? null : cBh.trim();
    }

    public Integer getnNum() {
        return nNum;
    }

    public void setnNum(Integer nNum) {
        this.nNum = nNum;
    }

    public String getcGoods() {
        return cGoods;
    }

    public void setcGoods(String cGoods) {
        this.cGoods = cGoods == null ? null : cGoods.trim();
    }

    public String getcPay() {
        return cPay;
    }

    public void setcPay(String cPay) {
        this.cPay = cPay == null ? null : cPay.trim();
    }
}