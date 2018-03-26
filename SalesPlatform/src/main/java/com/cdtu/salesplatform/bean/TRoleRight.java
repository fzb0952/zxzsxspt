package com.cdtu.salesplatform.bean;

public class TRoleRight {
    private String cBh;

    private String cRole;

    private String cRight;

    public String getcBh() {
        return cBh;
    }

    public void setcBh(String cBh) {
        this.cBh = cBh == null ? null : cBh.trim();
    }

    public String getcRole() {
        return cRole;
    }

    public void setcRole(String cRole) {
        this.cRole = cRole == null ? null : cRole.trim();
    }

    public String getcRight() {
        return cRight;
    }

    public void setcRight(String cRight) {
        this.cRight = cRight == null ? null : cRight.trim();
    }
}