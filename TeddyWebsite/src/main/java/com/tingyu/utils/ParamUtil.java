package com.tingyu.utils;

import com.tingyu.common.ICommonConstants;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 处理系统中 web请求中的参数
 *
 * 使用時需要在web.xml中配置监听器
 *
 * <listener>
 * <listener-class>
 *      org.springframework.web.context.request.RequestContextListener
 * </listener-class>
 * </listener>
 *
 * Created by tingyu on 2017/2/26.
 */
public class ParamUtil {
    private static Log log = LogFactory.getLog(ParamUtil.class);

    private static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    private static HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    private static Object get(String key) {
        return getRequest().getParameter(key);
    }

    /**
     * Get string from request.
     *
     * @param key the key
     * @return the string
     */
    public static String getString(String key) {
        Object value = get(key);
        if (null == value) {
            return null;
        }
        return value.toString();
    }


    /**
     * Get string arr string [ ].
     *
     * @param key the key
     * @return the string [ ]
     */
    public static String[] getStringArr(String key) {
        return getRequest().getParameterValues(key);
    }

    /**
     * Get intger from request.
     *
     * @param key the key
     * @return the integer
     */
    public static Integer getIntger(String key) {
        Object value = get(key);
        if (null == value) {
            return null;
        }
        Integer val = null;
        try {
            val = Integer.parseInt(value.toString());
        } catch (Exception e) {
            log.debug("参数类型转失败!", e);
        }
        return val;
    }

    /**
     * Get double double.
     *
     * @param key the key
     * @return the double
     */
    public static Double getDouble(String key) {
        Object value = get(key);
        if (null == value) {
            return null;
        }
        Double val = null;
        try {
            val = Double.valueOf(value.toString());
        } catch (Exception e) {
            log.debug("参数类型转失败!", e);
        }
        return val;
    }

    /**
     * Get float float.
     *
     * @param key the key
     * @return the float
     */
    public static Float getFloat(String key) {
        Object value = get(key);
        if (null == value) {
            return null;
        }
        Float val = null;
        try {
            val = Float.valueOf(value.toString());
        } catch (Exception e) {
            log.debug("参数类型转失败!", e);
        }
        return val;
    }

    /**
     * Get date date.
     *
     * @param key the key
     * @return the date
     */
    public static Date getDate(String key) {
        Object value = get(key);
        if (null == value) {
            return null;
        }
        Date date = null;
        try {
            date = SimpleDateFormat.getDateInstance().parse(value.toString());
        } catch (Exception e) {
            log.debug("参数类型转失败!", e);
        }
        return date;
    }

    /**
     * Get bean object.
     * 前台所传参数：
     * {
     * user.name: "tingyu",
     * user.age:12
     * }
     * key = user
     *
     * @param beanClass the bean class
     * @param key       the key
     * @return the object
     */
    public static Object getBean(Class beanClass, String key) {
        // 得到类中的所有属性集合
        Field[] fields = beanClass.getDeclaredFields();
        Object bean = null;
        try {
            bean = beanClass.newInstance();
            Object value = null;
            String attrKey = "";
            for (Field field : fields) {
                field.setAccessible(true);
                attrKey = key + ICommonConstants.PROPERTY_SEPARATE + field.getName();
                value = get(field.getType(),attrKey);
                field.set(bean, value);
            }
        } catch (Exception e) {
            log.debug(beanClass + "映射失败!", e);
        }
        return bean;
    }

    /**
     * Set attributes to response.
     * {key : value , ....}
     *
     * @param results the results
     */
    public static void setAttributes(Object results) {
        PrintWriter writer = null;
        try {
            writer = getResponse().getWriter();
            Object json = JSONObject.toJSONString(results);
            writer.print(json);
            writer.flush();
        } catch (IOException e) {
            if (null != writer) {
                writer.close();
            }
            log.debug("打开输出流失败!", e);
        } finally {
            if (null != writer) {
                writer.close();
            }
        }
    }

    /**
     * Set attribute.
     *
     * @param key   the key
     * @param value the value
     */
    public static void setAttribute(String key,Object value){
        Map<String,Object> result = new HashMap<>(0);
        result.put(key,value);
        setAttributes(result);
    }

    /**
     * 根据类型获取request中的参数
     * @param classType
     * @param attrKey
     * @return Object
     */
    private static Object get(Class classType,String attrKey){
        Object value = null;
        if (classType == String.class) {
            value = getString(attrKey);
        } else if (classType == String[].class) {
            value = getStringArr(attrKey);
        } else if (classType == Integer.class || classType == int.class) {
            value = getIntger(attrKey);
        } else if (classType == Float.class || classType == float.class) {
            value = getFloat(attrKey);
        } else if(classType == Double.class || classType == double.class){
            value = getDouble(attrKey);
        } else if(classType == Date.class){
            value = getDate(attrKey);
        }
        return value;
    }
}
