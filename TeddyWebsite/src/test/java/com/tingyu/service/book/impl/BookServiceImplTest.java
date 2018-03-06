package com.tingyu.service.book.impl;

import com.alibaba.fastjson.JSONObject;
import com.tingyu.BaseTest;
import com.tingyu.bean.page.PageBean;
import com.tingyu.dao.book.TBookMapper;
import com.tingyu.domain.book.TBook;
import com.tingyu.service.book.IBookService;
import jdk.nashorn.api.scripting.JSObject;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by tingyu on 2017/4/9.
 */
public class BookServiceImplTest extends BaseTest {
    @Resource
    IBookService iBookService;

    @Test
    public void getMyBooks() throws Exception {
        PageBean pageBean = new PageBean();
        pageBean.setnPageNow(0);
        pageBean.setnPageSize(10);

        List<TBook> tBooks = iBookService.getMyBooks(pageBean);
        System.out.println(JSONObject.toJSONString(tBooks));
    }

}