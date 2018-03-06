package com.tingyu.bean.page;

/**
 * Created by tingyu on 2017/4/8.
 * 定义分页相关的参数
 */
public class PageBean {
    private int nPageSize;
    private int nPageNow;

    public int getnPageSize() {
        return nPageSize;
    }

    public void setnPageSize(int nPageSize) {
        this.nPageSize = nPageSize;
    }

    public int getnPageNow() {
        return nPageNow;
    }

    public void setnPageNow(int nPageNow) {
        this.nPageNow = nPageNow;
    }
}
