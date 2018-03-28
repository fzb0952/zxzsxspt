package com.cdtu.salesplatform.bean;

import java.util.Date;

public class TActtip {
    private String cBh;

    private String cGoods;

    private Date dStartdate;

    private Date dEnddate;

    private String cDiscount;

    private String cDetails;

    public String getcBh() {
        return cBh;
    }

    public void setcBh(String cBh) {
        this.cBh = cBh == null ? null : cBh.trim();
    }

    public String getcGoods() {
        return cGoods;
    }

    public void setcGoods(String cGoods) {
        this.cGoods = cGoods == null ? null : cGoods.trim();
    }

    public Date getdStartdate() {
        return dStartdate;
    }

    public void setdStartdate(Date dStartdate) {
        this.dStartdate = dStartdate;
    }

    public Date getdEnddate() {
        return dEnddate;
    }

    public void setdEnddate(Date dEnddate) {
        this.dEnddate = dEnddate;
    }

    public String getcDiscount() {
        return cDiscount;
    }

    public void setcDiscount(String cDiscount) {
        this.cDiscount = cDiscount == null ? null : cDiscount.trim();
    }

    public String getcDetails() {
        return cDetails;
    }

    public void setcDetails(String cDetails) {
        this.cDetails = cDetails == null ? null : cDetails.trim();
    }
}