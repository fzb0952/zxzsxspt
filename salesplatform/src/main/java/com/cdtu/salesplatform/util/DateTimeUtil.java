package com.cdtu.salesplatform.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Properties;

/**
 * Created by fangzongzhou on 2017/6/20.
 */
public class DateTimeUtil {
    private static Logger logger = LoggerFactory.getLogger(DateTimeUtil.class);




    public static Date getYearLast(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();

        return currYearLast;
    }

    public static Date geyYearFirst(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year + 1);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }

    public static String getYear(int num) {

        String year = "";
        Calendar c = Calendar.getInstance();
        int years = -1 * num;
        c.setTime(new Date());
        c.add(Calendar.YEAR, years);



        year = String.valueOf(c.get(Calendar.YEAR));
        return year;
    }

    public static String getNDayBeforeCurrentDate(int num) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        int days = -1 * num * 7;
        String day = "";
        // 过去七天
        if (num == 0) {
            c.setTime(new Date());
            c.add(Calendar.DATE, days);
            Date d = c.getTime();
            day = format.format(d);
        } else {
            day = getLastDayForNweekMonday(num - 1);
        }

        return day;

    }

    public static String getNDayBeforeCurrentDateLast(int num) {

        String day = "";
        // 过去七天
        num = num - 1;
        day = getLastDayForNweekMonday(num + 1);

        return day;
    }

    /**
     * 获取前n周最后一天日期
     */
    public static String getLastDayforNweek(int n) {
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);//将每周第一天设为星期一，默认是星期天
        cal.add(Calendar.DATE, -n * 7);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        String sunday = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        return sunday;
    }

    /**
     * 获取前n周第一天日期
     */
    public static String getLastDayForNweekMonday(int n) {
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);//将每周第一天设为星期一，默认是星期天
        cal.add(Calendar.DATE, -n * 7);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        String monday = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        return monday;

    }

    public static String getNMonthBeforeCurrentDate(int num) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        String mon = "";
        int mons = -1 * num;
        // 过去一月
        c.setTime(new Date());
        c.add(Calendar.MONTH, mons);

        if (num == 0) {
            mon = format.format(new Date());
        } else if (num == 1) {
            mon = getLastMonthDate(0).substring(0, 8) + "01";
        } else if (num == 2) {
            mon = getLastMonthDate(1).substring(0, 8) + "01";
        }
        return mon;

    }

    public static String getNMonthBeforeCurrentDateLast(int num) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        String mon = "";
        int mons = -1 * num;
        // 过去一月
        c.setTime(new Date());
        c.add(Calendar.MONTH, mons);

        if (num == 0) {
            mon = format.format(new Date()).substring(0, 8) + "01";
        } else if (num == 1) {
            mon = getLastMonthDate(1).substring(0, 8) + "01";
        } else if (num == 2) {
            mon = getLastMonthDate(2).substring(0, 8) + "01";
        }
        return mon;
    }

    /**
     * 获取前n个月最后一天的日期
     */

    public static String getLastMonthDate(int i) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -i);
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        int MaxDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        //按你的要求设置时间
        c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), MaxDay);
        //按格式输出
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String gtime = sdf.format(c.getTime()); //上月最后一天

        return gtime;

    }

    public static String getNQuarterBeforeCurrentDate(int num) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();

        int quarterNum = -1 * num * 3;
        // 过去三个月
        c.setTime(new Date());
        c.add(Calendar.MONTH, quarterNum);
        int year = 0;
        String quater = null;
        if (num == 0) {
            Date y = c.getTime();
            quater = format.format(y);

        } else if (num == 1) {
            Calendar c1 = Calendar.getInstance();
            year = c1.get(Calendar.YEAR);
            switch (getQuarter() - 1) {
                case 0:
                    quater = (year-1) + "-10-01";
                    break;
                case 1:
                    quater = year + "-01-01";
                    break;
                case 2:
                    quater = year + "-04-01";
                    break;
                case 3:
                    quater = year + "-07-01";
                    break;
                default:
                    break;
            }
        } else if (num == 2) {
            Calendar c2 = Calendar.getInstance();
            year = c2.get(Calendar.YEAR);
            switch (getQuarter() - 2) {
                case -1:
                    quater = (year - 1) + "-07-01";
                    break;
                case 0:
                    quater = (year-1) + "-10-01";
                    break;
                case 1:
                    quater = year + "-01-01";
                    break;
                case 2:
                    quater = year + "-04-01";
                    break;
                default:
                    break;
            }
        } else if (num == 3) {
            Calendar c3 = Calendar.getInstance();
            year = c3.get(Calendar.YEAR);
            switch (getQuarter() - 3) {
                case 1:
                    quater = year  + "-01-01";
                    break;
                case 0:
                    quater = (year-1) + "-10-01";
                    break;
                case -1:
                    quater = (year - 1) + "-07-01";
                    break;
                case -2:
                    quater = (year - 1) + "-04-01";
                    break;
                default:
                    break;
            }
        }
        return quater;

    }

    public static String getNQuarterBeforeCurrentDateLast(int num) {

//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();

        int quarterNum = -1 * num * 3;
        // 过去三个月
        c.setTime(new Date());
        c.add(Calendar.MONTH, quarterNum);
        int year = 0;
        String quater = null;

        if (num == 0) {
            Calendar c1 = Calendar.getInstance();
            year = c1.get(Calendar.YEAR);
            switch (getQuarter()) {
                case 1:
                    quater = year + "-01-01";
                    break;
                case 2:
                    quater = year + "-04-01";
                    break;
                case 3:
                    quater = year + "-07-01";
                    break;
                case 4:
                    quater = year + "-10-01";
                    break;
                default:
                    break;

            }

        } else if (num == 1) {
            Calendar c1 = Calendar.getInstance();
            year = c1.get(Calendar.YEAR);
            switch (getQuarter() - 1) {
                case 0:
                    quater = (year - 1) + "-07-01";
                    break;
                case 1:
                    quater = year + "-10-01";
                    break;
                case 2:
                    quater = year + "-01-01";
                    break;
                case 3:
                    quater = year + "-04-01";
                    break;
                default:
                    break;
            }
        } else if (num == 2) {
            Calendar c2 = Calendar.getInstance();
            year = c2.get(Calendar.YEAR);
            switch (getQuarter() - 2) {
                case -1:
                    quater = (year - 1) + "-04-01";
                    break;
                case 0:
                    quater = (year - 1) + "-07-01";
                    break;
                case 1:
                    quater = (year-1) + "-10-01";
                    break;
                case 2:
                    quater = year + "-01-01";
                    break;
                default:
                    break;
            }
        } else if (num == 3) {
            Calendar c3 = Calendar.getInstance();
            year = c3.get(Calendar.YEAR);
            switch (getQuarter() - 3) {
                case 1:
                    quater = (year - 1) + "-10-01";
                    break;
                case 0:
                    quater = (year - 1) + "-07-01";
                    break;
                case -1:
                    quater = (year - 1) + "-04-01";
                    break;
                case -2:
                    quater = (year - 1) + "-01-01";
                    break;
                default:
                    break;
            }
        }
        return quater;

    }

    /**
     * 获取当前季度
     */
    public static int getQuarter() {
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        int quarter = 0;
        if (month >= 1 && month <= 3) {
            quarter = 1;
        }
        if (month >= 4 && month <= 6) {
            quarter = 2;
        }
        if (month >= 7 && month <= 9) {
            quarter = 3;
        }
        if (month >= 10 && month <= 12) {
            quarter = 4;
        }
        return quarter;

    }

    /**
     * 获取年
     *
     * @param num
     * @return
     */
    public static String getNyearBeforeCurrentDate(int num) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        int years = -1 * num;
        String year = "";
        c.setTime(new Date());
        c.add(Calendar.YEAR, years);
        if (years == 0) {
            year = format.format(new Date());
        } else {
            Date y = geyYearFirst(c.get(Calendar.YEAR));
            year = format.format(y);
        }

        return year;
    }

    /**
     * 获取本年第一天
     *
     * @param num
     * @return
     */
    public static String getNyearBeforeCurrentDateLast(int num) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        int years = -1 * num;
        String year = "";
        c.setTime(new Date());
        c.add(Calendar.YEAR, years);

        Date y = getYearLast(c.get(Calendar.YEAR));
        year = format.format(y).substring(0, 4) + "-01-01";

        return year;
    }



    public static Date getADayTimeStart(int n) {
        Calendar currentDate = new GregorianCalendar();
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        currentDate.add(Calendar.DATE, n);
        Date date = (Date) currentDate.getTime().clone();
        return date;
    }

    /**
     * @param strDate
     */
    public static java.sql.Date strToDate(String strDate) {
        String str = strDate;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = null;
        try {
            d = format.parse(str);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        java.sql.Date date = null;
        if (d != null) {
            date = new java.sql.Date(d.getTime());
        }

        return date;
    }

    /**
     * 加载配置文件配置项
     */
    public String getProperties() {
        String fyid = "";
        Properties prop = new Properties();
        InputStream inputStream = null;
        try {
            //读取属性文件a.properties
            //InputStream in = new BufferedInputStream(new FileInputStream("config.properties"));
            inputStream = this.getClass().getResourceAsStream("/resource/props/config.properties");
            prop.load(inputStream); ///加载属性列表
            Iterator<String> it = prop.stringPropertyNames().iterator();
            while (it.hasNext()) {
                String key = it.next();
                if (key.equals("fyid")) {
                    fyid = prop.getProperty(key);
                }

            }

        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    logger.error(e.getMessage());
                }
            }
        }
        return fyid;

    }

}
