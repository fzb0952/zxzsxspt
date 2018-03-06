package com.tingyu.cache;

import com.sun.istack.internal.Nullable;

/**
 * 所有cache的基类
 * Created by tingyu on 2017/2/26.
 */
public abstract class CacheBase {
    /**
     * Init.
     */
    public abstract void init();

    /**
     * Refresh.
     * 子类如果需要刷新的话，重写即可
     */
    public void refresh(){}


    /**
     * Gets cache.
     *
     * @param params the params
     * @return the cache
     */
    public abstract Object getCache(@Nullable Object params);
}
