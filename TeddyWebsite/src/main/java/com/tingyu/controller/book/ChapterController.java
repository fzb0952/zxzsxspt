package com.tingyu.controller.book;

import com.tingyu.common.ICommonConstants;
import com.tingyu.domain.book.TChapter;
import com.tingyu.service.book.IBookService;
import com.tingyu.service.book.IChapterService;
import com.tingyu.utils.ParamUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tingyu on 2017/4/16.
 */
@Controller
@RequestMapping("admin/chapter")
public class ChapterController {

    @Autowired
    private IChapterService chapterService;

    @Autowired
    private IBookService bookService;

    /**
     * Get book by id.
     *
     * @param bookId the book id
     */
    @RequestMapping("bookId/{bookId}")
    @ResponseBody
    public void getBookById(@PathVariable String bookId){
        if(!StringUtils.isBlank(bookId)){
            ParamUtil.setAttribute("book",bookService.getBookById(bookId));
        }
    }

    /**
     * Gets chapters by book id.
     *
     * @param bookId the book id
     */
    @RequestMapping("chapters/{bookId}")
    @ResponseBody
    public void getChaptersByBookId(@PathVariable("bookId")String bookId){
        if(StringUtils.isNotBlank(bookId)){
            ParamUtil.setAttribute("chapters",chapterService.getChaptersByBookId(bookId));
        }
    }

    /**
     * Gets chapter by chapter id.
     *
     * @param chapterId the chapter id
     */
    @RequestMapping("chapter/{chapterId}")
    @ResponseBody
    public void getChapterByChapterId(@PathVariable("chapterId")String chapterId){
        if(StringUtils.isNotBlank(chapterId)){
            ParamUtil.setAttribute("chapter",chapterService.getChapterByChapterId(chapterId));
        }
    }

    /**
     * Save chapter info.
     */
    @RequestMapping("saveChapter")
    @ResponseBody
    public void saveChapterInfo(){
        TChapter chapter = (TChapter)ParamUtil.getBean(TChapter.class,"chapter");
        if(null == chapter){
            ParamUtil.setAttribute(ICommonConstants.C_ERROR,"章节信息为空，重新填写！");
            return;
        }

        if(chapterService.saveChapterInfo(chapter)){
            ParamUtil.setAttribute(ICommonConstants.C_SUCCESS,"章节信息暂存成功！");
        }else{
            ParamUtil.setAttribute(ICommonConstants.C_ERROR,"章节信息暂存失败，请联系管理员！");
        }
    }

    /**
     * Publish chapter info.
     */
    @RequestMapping("publishChapter")
    @ResponseBody
    public void publishChapterInfo(){
        TChapter chapter = (TChapter)ParamUtil.getBean(TChapter.class,"chapter");
        if(null == chapter){
            ParamUtil.setAttribute(ICommonConstants.C_ERROR,"章节信息为空，重新填写！");
            return;
        }

        if(chapterService.publishChapter(chapter)){
            ParamUtil.setAttribute(ICommonConstants.C_SUCCESS,"章节发布成功！");
        }else{
            ParamUtil.setAttribute(ICommonConstants.C_ERROR,"章节发布失败，请联系管理员！");
        }
    }
}
