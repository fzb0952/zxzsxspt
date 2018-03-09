package com.cdtu.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * <!-- 配置SpringUtil 否则获取的ApplicationContext对象将为null。 -->
 * <bean id="SpringUtil" class="com.tingyu.utils.SpringUtil"></bean>
 */
public class SpringUtil implements ApplicationContextAware{
    private static ApplicationContext applicationContext;  
    
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtil.applicationContext = applicationContext;
    }
    
    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }

}
