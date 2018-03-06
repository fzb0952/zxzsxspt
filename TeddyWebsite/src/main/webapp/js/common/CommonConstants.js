/**
 * 用于存放系统所用到的常量
 * Created by tingyu on 2017/2/26.
 */
var CommonConstants = {
    // 字体定义
    /** 华文行楷 */
    FONTS_ST_XINGKAI: "STXingkai",
    /** 字体大小 -- 常规 */
    FONT_WEIGHT_REGULAR: "Regular",
    /** 字体大小 -- 黑体 */
    FONT_WEIGHT_BOLD: "BOLD",
    /** 属性分隔符 "." */
    PROPERTY_SEPARATE: ".",
    /** 属性连接符 "_" */
    PROPERTY_CONNECTOR: "_",
    /** 值分隔符  ";" */
    VALUE_SEPARATE: ";",
    /** 字符串类型成功标识 */
    C_SUCCESS: "success",
    /** 字符串类型的失败标识 */
    C_ERROR: "error",
}
/**
 * layer 弹出层相关类型定义
 * 窗口类型： 0（信息框，默认），1（页面层），2（iframe层），3（加载层），4（tips层）
 * ICON类型：0警告，1成功，2错误，3疑问，4锁，5悲伤，6高兴
 */
var Layer = {
    LAYER_MESSAGE : 0,  //信息框，默认
    LAYER_PAGE : 1,     //页面层
    LAYER_IFRAME : 2,   //iframe层
    LAYER_LOADING : 3,  //加载层
    LAYER_TIPS : 4,     //tips层

    ICON_WARN : 0,      //警告
    ICON_SUCCESS : 1,   //成功
    ICON_ERROR : 2,     //错误
    ICON_QUESTION: 3,   //疑问
    ICON_LOCK : 4,      //锁
    ICON_SAD : 5,       //悲伤
    ICON_HAPPY : 6      //高兴
}