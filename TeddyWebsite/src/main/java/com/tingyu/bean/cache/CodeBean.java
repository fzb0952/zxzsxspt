package com.tingyu.bean.cache;

/**
 * 用于查询单值代码   以及    返回前台的数据
 * Created by tingyu on 2017/4/4.
 */
public class CodeBean {
    private Integer nCodeType;
    private String cCodeTypeName;
    private Integer nCode;
    private String cCodeName;
    private Integer nShowOrder;
    private String cSpellingCode;

    public CodeBean(Integer nCodeType, String cCodeTypeName, Integer nCode, String cCodeName, Integer nShowOrder, String cSpellingCode) {
        this.nCodeType = nCodeType;
        this.cCodeTypeName = cCodeTypeName;
        this.nCode = nCode;
        this.cCodeName = cCodeName;
        this.nShowOrder = nShowOrder;
        this.cSpellingCode = cSpellingCode;
    }

    public Integer getnCodeType() {
        return nCodeType;
    }

    public void setnCodeType(Integer nCodeType) {
        this.nCodeType = nCodeType;
    }

    public String getcCodeTypeName() {
        return cCodeTypeName;
    }

    public void setcCodeTypeName(String cCodeTypeName) {
        this.cCodeTypeName = cCodeTypeName;
    }

    public Integer getnCode() {
        return nCode;
    }

    public void setnCode(Integer nCode) {
        this.nCode = nCode;
    }

    public String getcCodeName() {
        return cCodeName;
    }

    public void setcCodeName(String cCodeName) {
        this.cCodeName = cCodeName;
    }

    public Integer getnShowOrder() {
        return nShowOrder;
    }

    public void setnShowOrder(Integer nShowOrder) {
        this.nShowOrder = nShowOrder;
    }

    public String getcSpellingCode() {
        return cSpellingCode;
    }

    public void setcSpellingCode(String cSpellingCode) {
        this.cSpellingCode = cSpellingCode;
    }
}
