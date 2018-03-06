package com.tingyu.cache;

import com.tingyu.BaseTest;
import com.tingyu.bean.cache.CodeBean;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by tingyu on 2017/4/4.
 */
public class CodeCacheTest extends BaseTest {
    @Test
    public void getCache() throws Exception {
        assertEquals(2,((List<CodeBean>)CodeCache.getInstance().getCache(10100001)).size());
    }

}