package com.tingyu.controller.book;

import com.tingyu.bean.page.PageBean;
import com.tingyu.common.ICommonConstants;
import com.tingyu.domain.book.TBook;
import com.tingyu.service.book.IBookService;
import com.tingyu.utils.ParamUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by tingyu on 2017/4/3.
 */
@RequestMapping("admin/book")
@Controller
public class BookController {
    private Log log = LogFactory.getLog(BookController.class);

    @Autowired
    private IBookService iBookService;

    /**
     * Add book.
     */
    @RequestMapping("add")
    @ResponseBody
    public void addBook(){
        TBook tBook = (TBook) ParamUtil.getBean(TBook.class,"book");
        if(null == tBook){
            ParamUtil.setAttribute(ICommonConstants.C_ERROR,"添加书籍为空，请检查！");
            return;
        }
        if(!iBookService.addBook(tBook)){
            ParamUtil.setAttribute(ICommonConstants.C_ERROR,"添加书籍失败，请联系管理员！");
        }
        ParamUtil.setAttribute(ICommonConstants.C_SUCCESS,"添加书籍成功！");
    }

    /**
     * Get my books.
     */
    @RequestMapping("books")
    @ResponseBody
    public void getMyBooks(){
        PageBean pageBean = (PageBean)ParamUtil.getBean(PageBean.class,"page");
        if(null == pageBean){
            ParamUtil.setAttribute(ICommonConstants.C_ERROR,"分页信息不全！");
            return;
        }
        List<TBook> books = iBookService.getMyBooks(pageBean);
        ParamUtil.setAttribute("books",books);
    }

    /**
     * Get book by id string.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping("bookId/{bookId}")
    public String getBookById(@PathVariable String bookId, Model model){
        if(!StringUtils.isBlank(bookId)){
            model.addAttribute("book",iBookService.getBookById(bookId));
        }
        return "admin/book/create-book";
    }

    /**
     * Update book.
     */
    @RequestMapping("update")
    @ResponseBody
    public void updateBook(){
        TBook tBook = (TBook)ParamUtil.getBean(TBook.class,"book");
        if(iBookService.updateBook(tBook)){
            ParamUtil.setAttribute(ICommonConstants.C_SUCCESS,"修改成功！");
        }
        ParamUtil.setAttribute(ICommonConstants.C_ERROR,"修改失败！");
    }
}
