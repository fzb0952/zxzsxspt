package com.tingyu.cache;

import com.tingyu.common.ICacheConstants;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 管理所有cache
 * Created by tingyu on 2017/2/26.
 */
public class CacheManager {
    private static Map<String,CacheBase> cacheMap = new HashMap<String,CacheBase>(0);
    static {
        cacheMap.put(ICacheConstants.FONT_CAHCE,FontsCache.getInstance());
        cacheMap.put(ICacheConstants.CODE_CACHE,CodeCache.getInstance());
    }

    /**
     * 私有构造函数  单利模式
     */
    private CacheManager(){

    }

    private static class SingletonClassInstance {
        private static final CacheManager instance = new CacheManager();
    }

    /**
     * Gets  CacheManager instance.
     * @return the instance
     */
    public static CacheManager getInstance() {
        return SingletonClassInstance.instance;
    }

    /**
     * Init cache.
     */
    public void initCache(){
        Iterator<Map.Entry<String,CacheBase>> cacheIterator = cacheMap.entrySet().iterator();
        Map.Entry<String,CacheBase> entry = null;
        CacheBase cache = null;
        while (cacheIterator.hasNext()){
            entry = cacheIterator.next();
            cache = entry.getValue();
            cache.init();
        }
    }
}
