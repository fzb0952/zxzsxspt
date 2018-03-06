package com.tingyu.listenler;

import com.tingyu.cache.CacheManager;
import com.tingyu.utils.FileUtil;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

/**
 * SpringMVC加载完毕之后的监听器
 * Created by tingyu on 2017/2/26.
 */
@Service
public class StratupListenler implements ApplicationListener<ContextRefreshedEvent> {

    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(event.getApplicationContext().getParent() == null){//root application context 没有parent，他就是老大.
            CacheManager.getInstance().initCache();
        }
    }
}
