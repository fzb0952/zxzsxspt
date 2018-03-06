package com.tingyu.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tingyu.bean.cache.CodeBean;
import com.tingyu.common.ICommonConstants;
import com.tingyu.utils.CodeUtil;
import com.tingyu.utils.ParamUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by tingyu on 2017/4/4.
 * Utils controller  返回前台所需要的一些常用信息，例如：单值代码
 */
@RequestMapping("util")
@Controller
public class UtilController {
    private Log log = LogFactory.getLog(UtilController.class);

    /**
     * Get code.
     */
    @RequestMapping("code")
    @ResponseBody
    public void getCode(){
        Integer codeType = ParamUtil.getIntger("codeType");
        if(null == codeType){
            log.error("codeType is null！");
            ParamUtil.setAttribute(ICommonConstants.C_ERROR,"codeType is null！");
            return;
        }
        List<CodeBean> codes = CodeUtil.getCodeByType(codeType);
        ParamUtil.setAttribute("value",codes);
    }

    /**
     * Get code values.
     */
    @RequestMapping("codeValues")
    @ResponseBody
    public void getCodeValues(){
        String codes = ParamUtil.getString("codes");
        if(StringUtils.isBlank(codes)){
            ParamUtil.setAttribute(ICommonConstants.C_ERROR,"参数为空！");
        }
        JSONArray codeJsonArr = JSONArray.parseArray(codes);
        JSONObject codeJson = null;
        for (Object code : codeJsonArr) {
            codeJson = ((JSONObject)code);
            codeJson.put("codeName",CodeUtil.getCodeName(codeJson.getIntValue("codeType"),codeJson.getIntValue("codeValue")));
        }
        ParamUtil.setAttribute("codes",codeJsonArr);
    }
}
