package com.tingyu.service.book.impl;

import com.tingyu.bean.page.PageBean;
import com.tingyu.dao.book.TBookMapper;
import com.tingyu.domain.book.TBook;
import com.tingyu.domain.userinfo.TAdmin;
import com.tingyu.service.book.IBookService;
import com.tingyu.utils.ParamUtil;
import com.tingyu.utils.SessionUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by tingyu on 2017/4/8.
 */
@Service
public class BookServiceImpl implements IBookService {
    private Log log = LogFactory.getLog(BookServiceImpl.class);

    @Resource
    private TBookMapper tBookMapper;

    /**
     * Add book boolean.
     *
     * @param tBook the t book
     * @return the boolean
     */
    @Override
    public boolean addBook(TBook tBook) {
        TAdmin tAdmin = SessionUtil.getCurrentAdmin();
        if(null == tAdmin){
            return false;
        }
        tBook.setcAuthorId(tAdmin.getcId());
        tBook.setcAuthorName(tAdmin.getcName());
        tBook.setnWordCount(0);
        tBook.setDtCreateTime(new Date());
        return tBookMapper.insert(tBook) == 1;
    }

    /**
     * Gets my books.
     *
     * @return the my books
     */
    @Override
    public List<TBook> getMyBooks(PageBean pageBean) {
        int nPageSize = pageBean.getnPageSize();
        int nPageNow = pageBean.getnPageNow() * nPageSize;
        return tBookMapper.getAllBooksByPage(nPageSize,nPageNow);
    }

    @Override
    public TBook getBookById(String bookId) {
        return tBookMapper.selectByPrimaryKey(bookId);
    }

    @Override
    public boolean updateBook(TBook book) {
        if(null == book || StringUtils.isBlank(book.getcId())){
            return false;
        }
        return tBookMapper.updateByPrimaryKeySelective(book) == 1;
    }
}
