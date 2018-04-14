package com.cdtu.salesplatform.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtil {

    private static Logger logger = LoggerFactory.getLogger(DateUtil.class);

    /**
     * 获取某月的最后一天
     * 
     * @param date
     * @return
     */
    public static String lastDayOfMon(String date) {
        return lastDayOfMon(date, "yyyy-MM-dd");
    }

    /**
     * 获取某月的最后一天
     * 
     * @param date
     * @param formatPattern
     *            格式化的匹配格式
     * @return
     */
    public static String lastDayOfMon(String date, String formatPattern) {
        int year = Integer.valueOf(date.substring(0, 4));
        int mon = Integer.valueOf(date.substring(5, 7));
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, mon);
        calendar.set(Calendar.DAY_OF_MONTH, 1);// set to first day of this month
        calendar.add(Calendar.DAY_OF_MONTH, -1);// set to last day of last month
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date lastDate = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(formatPattern);
        return sdf.format(lastDate);
    }

    /**
     * 获取本月第一天
     * 
     * @param date
     * @param formatPattern
     *            格式化的匹配格式
     * @return
     */
    public static String firstDayOfMon(String date) {
        return firstDayOfMon(date, "yyyy-MM-dd");
    }

    /**
     * 获取本月第一天
     * 
     * @param date
     * @return
     */
    public static String firstDayOfMon(String date, String formatPattern) {
        int y = Integer.valueOf(date.substring(0, 4));
        int m = Integer.valueOf(date.substring(5, 7));
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, y);
        c.set(Calendar.MONTH, m);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        Date firstDay = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(formatPattern);
        return sdf.format(firstDay);
    }

    /**
     * @Description: 获得给定日期的上月第一天
     * @param @param date
     * @param @return
     * @return String 返回类型
     */
    public static String firstDayOfPreMon(String date, String pattern) {
        int yer = Integer.valueOf(date.substring(0, 4));
        int mon = Integer.valueOf(date.substring(5, 7));
        Calendar cld = Calendar.getInstance();
        cld.set(Calendar.YEAR, yer);
        cld.set(Calendar.MONTH, mon);
        cld.set(Calendar.DAY_OF_MONTH, 1);// set to this month first day
        cld.add(Calendar.MONTH, -2);// set to last month
        cld.set(Calendar.HOUR, 0);
        cld.set(Calendar.MINUTE, 0);
        cld.set(Calendar.SECOND, 0);
        Date firstDay = cld.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(firstDay);
    }

    /**
     * 获取pre月的最后一天
     * 
     * @param date
     * @param formatPattern
     *            格式化的匹配格式
     * @return
     */
    public static String lastDayOfPreMon(String date, String pattern) {
        int year = Integer.valueOf(date.substring(0, 4));
        int month = Integer.valueOf(date.substring(5, 7));
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);// set to first day of this month
        cal.add(Calendar.DAY_OF_MONTH, -1);// set to last day of last month
        cal.set(Calendar.HOUR, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        Date lastDate = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(lastDate);
    }

    public static String lastDayOfPreMon(String date) {
        return lastDayOfPreMon(date, "yyyy-MM-dd");
    }

    public static String firstDayOfPreMon(String date) {
        return firstDayOfPreMon(date, "yyyy-MM-dd");
    }

    /**
     * 将时间字符串转换成日期
     * 
     * @param dateString
     * @return
     */
    public static Date strToDate(String datetimeStr) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(datetimeStr);
        } catch (ParseException e) {
            logger.error("字符串：" + datetimeStr + " 转时间出错。   错误信息" + e.getMessage());
        }
        return date;
    }

    /**
     * @Description: 获得简单的格式化时间
     * @param date
     * @return String 返回类型
     */
    public static String getFormatedDate(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern); //
        return sdf.format(date);
    }

    /**
     * @Description: 获得简单的格式化时间
     * @param date
     * @return String 返回类型
     */
    public static String getFormatedDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //
        return sdf.format(date);
    }
}
