package com.tingyu.dao.basic;

import com.tingyu.BaseTest;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by tingyu on 2017/4/4.
 */
public class TCodeInfoMapperTest extends BaseTest {

    @Resource
    TCodeTypeMapper tCodeTypeMapper;

    @Test
    public void selectAllCodeInfo() throws Exception {
        assertNotEquals(0,tCodeTypeMapper.selectAllCodeType().size());
    }

}