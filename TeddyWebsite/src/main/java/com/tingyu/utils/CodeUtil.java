package com.tingyu.utils;

import com.tingyu.bean.cache.CodeBean;
import com.tingyu.cache.CodeCache;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by tingyu on 2017/4/4.
 * 单值代码工具类，封装常用的单值代码操作
 */
public class CodeUtil {

    /**
     * Get code by type list.
     *
     * @param nCodeType the n code type
     * @return the list
     */
    public static List<CodeBean> getCodeByType(int nCodeType){
        List<CodeBean> codes = (List<CodeBean>)CodeCache.getInstance().getCache(nCodeType);
        return codes;
    }

    /**
     * Get code name string.
     *
     * @param nCodeType  the n code type
     * @param nCodeValue the n code value
     * @return the string
     */
    public static String getCodeName(int nCodeType,int nCodeValue){
        List<CodeBean> codes = (List<CodeBean>)CodeCache.getInstance().getCache(nCodeType);
        if(!CollectionUtils.isEmpty(codes)){
            for (CodeBean code : codes) {
                if(nCodeValue == code.getnCode().intValue()){
                    return code.getcCodeName();
                }
            }
        }
        return null;
    }
}
