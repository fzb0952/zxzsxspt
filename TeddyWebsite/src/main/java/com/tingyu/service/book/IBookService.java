package com.tingyu.service.book;

import com.tingyu.bean.page.PageBean;
import com.tingyu.domain.book.TBook;

import java.util.List;

/**
 * Created by tingyu on 2017/4/8.
 */
public interface IBookService {

    /**
     * Add book boolean.
     *
     * @param tBook the t book
     * @return the boolean
     */
    boolean addBook(TBook tBook);

    /**
     * Gets my books.
     *
     * @param pageBean the page bean
     * @return the my books
     */
    List<TBook> getMyBooks(PageBean pageBean);

    /**
     * Gets book by id.
     *
     * @param bookId the book id
     * @return the book by id
     */
    TBook getBookById(String bookId);

    /**
     * Update book boolean.
     *
     * @param book the book
     * @return the boolean
     */
    boolean updateBook(TBook book);
}
