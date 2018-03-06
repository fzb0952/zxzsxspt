package com.tingyu.dao.basic;

import com.tingyu.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by tingyu on 2017/4/4.
 */
public class TCodeTypeMapperTest extends BaseTest {
    @Resource
    TCodeTypeMapper tCodeTypeMapper;

    @Test
    public void selectAllCodeType() throws Exception {
        assertNotEquals(0,tCodeTypeMapper.selectAllCodeType());
    }

    @Test
    public void selectAllCodeTypeAndInfo() throws Exception {
        assertNotEquals(0,tCodeTypeMapper.selectAllCodeTypeAndInfo());
    }

}