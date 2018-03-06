package com.tingyu.dao.book;

import com.tingyu.BaseTest;
import com.tingyu.domain.book.TBook;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by tingyu on 2017/4/8.
 */
public class TBookMapperTest extends BaseTest {
    @Resource
    TBookMapper tBookMapper;

    @Test
    public void insert() throws Exception {
        TBook tBook = new TBook();
        tBook.setcAuthorId("sdkfeixjde");
        tBook.setcAuthorName("tingyu");
        tBook.setcBookName("Teddy");
        tBook.setnBookType(1);
        tBook.setnWordCount(0);
        tBook.setDtCreateTime(new Date());
        tBook.setnPublishState(1);

        assertEquals(1,tBookMapper.insert(tBook));
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        assertNotNull(tBookMapper.selectByPrimaryKey("c0a800685b4c1338815b4c53382b0000"));
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
        TBook tBook = tBookMapper.selectByPrimaryKey("c0a800685b4c1338815b4c53382b0000");
        assertNotNull(tBook);

        tBook.setnWordCount(1);
        assertEquals(1,tBookMapper.updateByPrimaryKey(tBook));
    }

}