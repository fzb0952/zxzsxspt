package com.tingyu.cache;

import com.tingyu.bean.cache.CodeBean;
import com.tingyu.dao.basic.TCodeInfoMapper;
import com.tingyu.dao.basic.TCodeTypeMapper;
import com.tingyu.domain.basic.TCodeInfo;
import com.tingyu.domain.basic.TCodeType;
import com.tingyu.utils.SpringUtil;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Created by tingyu on 2017/4/4.
 */
public final class CodeCache extends CacheBase {
    private Map<Integer,List<CodeBean>> codeInfoMap = new HashMap<Integer,List<CodeBean>>(0);

    private static class SingletonClassInstance {
        private static final CodeCache instance = new CodeCache();
    }

    private void buildCodeCache(List<CodeBean> codeInfos){
        List<CodeBean> codes = null;
        for (CodeBean codeBean : codeInfos) {
            codes = codeInfoMap.get(codeBean.getnCodeType());
            if(null == codes){
                codes = new ArrayList<>(0);
                codeInfoMap.put(codeBean.getnCodeType(),codes);
            }
            codes.add(codeBean);
        }
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static CodeCache getInstance() {
        return CodeCache.SingletonClassInstance.instance;
    }

    /**
     * Init.
     */
    @Override
    public void init() {
        TCodeTypeMapper tCodeTypeMapper = (TCodeTypeMapper)SpringUtil.getBean("TCodeTypeMapper");
        List<CodeBean> codeInfos = tCodeTypeMapper.selectAllCodeTypeAndInfo();

        if(!CollectionUtils.isEmpty(codeInfos)){
            buildCodeCache(codeInfos);
        }
    }

    @Override
    public void refresh() {
        codeInfoMap.clear();
        init();
    }

    /**
     * Gets cache.
     *
     * @param params the params is Integer
     * @return the cache
     */
    @Override
    public Object getCache(Object params) {
        if(null == params || !(params instanceof Integer)){
            return null;
        }
        Integer codeType = Integer.valueOf(params.toString());
        // 暂时只按照代码类型查询，后期有需要再添加
        return codeInfoMap.get(codeType);
    }
}
