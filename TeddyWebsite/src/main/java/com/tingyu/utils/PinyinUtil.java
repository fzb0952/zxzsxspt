package com.tingyu.utils;

import net.sourceforge.pinyin4j.PinyinHelper;

/**
 * Created by tingyu on 2017/5/1.
 */
public class PinyinUtil {

    /**
     * Get pin yin head char string.
     *
     * @param string the string
     * @return the string
     */
    public static String getPinYinHeadChar(String string) {
        String convert = "";
        for (int j = 0; j < string.length(); j++) {
            char word = string.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert += pinyinArray[0].charAt(0);
            } else {
                convert += word;
            }
        }
        return convert;
    }
}
