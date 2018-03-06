package com.tingyu.utils;

import com.tingyu.domain.userinfo.TAdmin;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

/**
 * Created by tingyu on 2017/4/3.
 */
public class SessionUtil {
    private static String SESSION_NAME_ADMIN = "admin";
    /** 登录最大有效时间 */
    private static int MaxInactiveInterval = 30 * 60 * 1000;

    private static HttpSession getSession() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
    }

    /**
     * Set admin.
     *
     * @param admin the admin
     */
    public static void setAdmin(TAdmin admin) {
        if (null != admin) {
            getSession().setMaxInactiveInterval(MaxInactiveInterval);
            getSession().setAttribute(SESSION_NAME_ADMIN, admin);
        }
    }

    /**
     * Clear admin.
     */
    public static void clearAdmin(){
        getSession().removeAttribute(SESSION_NAME_ADMIN);
    }

    /**
     * Get current admin t admin.
     *
     * @return the t admin
     */
    public static TAdmin getCurrentAdmin() {
        Object session = getSession().getAttribute(SESSION_NAME_ADMIN);
        if (null == session) {
            return null;
        }
        return (TAdmin) session;
    }
}
