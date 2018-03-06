package com.tingyu.service.book.impl;

import com.tingyu.common.ICodeConstants;
import com.tingyu.dao.book.TChapterMapper;
import com.tingyu.domain.book.TChapter;
import com.tingyu.service.book.IChapterService;
import com.tingyu.utils.PinyinUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by tingyu on 2017/4/16.
 */
@Service
public class ChapterServiceImpl implements IChapterService {

    @Autowired
    private TChapterMapper tChapterMapper;

    @Override
    public List<TChapter> getChaptersByBookId(String bookId) {
        return tChapterMapper.selectByBookId(bookId);
    }

    /**
     * Save chapter info boolean.
     *
     * @param chapter the chapter
     * @return the boolean
     */
    @Override
    public boolean saveChapterInfo(TChapter chapter) {
        if(StringUtils.isBlank(chapter.getcId())){
            chapter.setDtCreateTime(new Date());
        }
        chapter.setnPublishState(ICodeConstants.CODE_PUBLISH_STATE_SAVE);
        chapter.setcSpellingCode(PinyinUtil.getPinYinHeadChar(chapter.getcChapterName()));
        // ID为空时表示新增
        if(StringUtils.isBlank(chapter.getcId())){
            return 1 == tChapterMapper.insert(chapter);
        }
        return 1 == tChapterMapper.updateByPrimaryKeySelective(chapter);
    }

    /**
     * Publish chapter boolean.
     *
     * @param chapter the chapter
     * @return the boolean
     */
    @Override
    public boolean publishChapter(TChapter chapter) {
        if(StringUtils.isBlank(chapter.getcId())){
            chapter.setDtCreateTime(new Date());
        }
        chapter.setnPublishState(ICodeConstants.CODE_PUBLISH_STATE_PUBLISH);
        chapter.setDtPublishTime(new Date());
        chapter.setcSpellingCode(PinyinUtil.getPinYinHeadChar(chapter.getcChapterName()));
        // ID为空时表示新增
        if(StringUtils.isBlank(chapter.getcId())){
            return 1 == tChapterMapper.insert(chapter);
        }
        return  1 == tChapterMapper.updateByPrimaryKeySelective(chapter);
    }

    /**
     * Gets chapter by chapter id.
     *
     * @param chapterId the chapter id
     * @return the chapter by chapter id
     */
    @Override
    public TChapter getChapterByChapterId(String chapterId) {
        return tChapterMapper.selectByPrimaryKey(chapterId);
    }
}
