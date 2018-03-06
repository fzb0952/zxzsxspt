package com.tingyu.bean.cache;

/**
 * font查询相关参数定义
 * Created by tingyu on 2017/2/26.
 */
public class FontBean {
    private String fontType;
    private String fontWeight;
    private String fontSearchParams;

    public String getFontSearchParams() {
        return fontSearchParams;
    }

    public void setFontSearchParams(String fontSearchParams) {
        this.fontSearchParams = fontSearchParams;
    }

    public String getFontWeight() {
        return fontWeight;
    }

    public void setFontWeight(String fontWeight) {
        this.fontWeight = fontWeight;
    }

    public String getFontType() {

        return fontType;
    }

    public void setFontType(String fontType) {
        this.fontType = fontType;
    }
}
