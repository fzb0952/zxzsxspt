package com.tingyu.utils;

import com.tingyu.BaseTest;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tingyu on 2017/4/4.
 */
public class CodeUtilTest extends BaseTest {
    @Test
    public void getCodeByType() throws Exception {
        assertEquals(2,CodeUtil.getCodeByType(10100001).size());
    }

}