package com.tingyu.service.book;

import com.tingyu.domain.book.TChapter;

import java.util.List;

/**
 * Created by tingyu on 2017/4/16.
 */
public interface IChapterService {

    /**
     * Gets chapters by book id.
     *
     * @param bookId the book id
     * @return the chapters by book id
     */
    List<TChapter> getChaptersByBookId(String bookId);


    /**
     * Save chapter info boolean.
     *
     * @param chapter the chapter
     * @return the boolean
     */
    boolean saveChapterInfo(TChapter chapter);

    /**
     * Publish chapter boolean.
     *
     * @param chapter the chapter
     * @return the boolean
     */
    boolean publishChapter(TChapter chapter);

    /**
     * Gets chapter by chapter id.
     *
     * @param chapterId the chapter id
     * @return the chapter by chapter id
     */
    TChapter getChapterByChapterId(String chapterId);
}
