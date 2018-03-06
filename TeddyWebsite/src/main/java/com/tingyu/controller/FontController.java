package com.tingyu.controller;

import com.tingyu.bean.cache.FontBean;
import com.tingyu.cache.FontsCache;
import com.tingyu.common.ICommonConstants;
import com.tingyu.utils.ParamUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tingyu on 2017/2/26.
 */
@Controller
@RequestMapping(value = "fonts")
public class FontController {

    /**
     * Search font.
     *
     */
    @RequestMapping(value = "search")
    @ResponseBody
    public void searchFont(){
        Map<String,Object> result = new HashMap<String,Object>(0);

        FontBean fontBean = (FontBean)ParamUtil.getBean(FontBean.class,"font");
        JSONObject font = (JSONObject)FontsCache.getInstance().getCache(fontBean);
        if(null == font || font.isEmpty()){
            result.put(ICommonConstants.C_ERROR,"查询字体失败！");
        }
        result.put(ICommonConstants.C_SUCCESS,font);

        ParamUtil.setAttributes(result);
    }
}
