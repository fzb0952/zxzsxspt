package com.cdtu.salesplatform.bean;

public class TCar {
    private String cBh;

    private Integer nNum;

    private String cGoods;

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
}