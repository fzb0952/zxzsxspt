package com.tingyu.cache;

import com.tingyu.bean.cache.FontBean;
import com.tingyu.common.ICommonConstants;
import com.tingyu.utils.FileUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 字体缓存，解决THREE.js加载字体文件太慢的问题
 * Created by tingyu on 2017/2/26.
 */
public final class FontsCache extends CacheBase {
    private static Map<String,JSONObject> fonts = new HashMap<String,JSONObject>(0);
    private static Log log = LogFactory.getLog(FontsCache.class);

    private static class SingletonClassInstance {
        private static final FontsCache instance = new FontsCache();
    }

    /**
     * Gets  CacheManager instance.
     *
     * @return the instance
     */
    public static FontsCache getInstance() {
        return SingletonClassInstance.instance;
    }

    private FontsCache() {
    }

    /**
     * Init.
     */
    @Override
    public void init() {
        String fontsPath = FileUtil.getWebappPath() + File.separator + "fonts";
        FileUtil.unzip(fontsPath + File.separator + "fonts.zip",fontsPath);

        File file = new File(fontsPath);

        if(!file.exists() || !file.isDirectory()){
            log.error("字体文件不存在！");
        }
        File[] fontFiles = file.listFiles();
        if(null == fontFiles){
            log.error("字体文件不存在！");
            return;
        }
        String fontName = "";
        String fontContent = "";
        JSONObject fontJson;
        for (File fontFile: fontFiles) {
            fontName = fontFile.getName();
            if(!fontName.endsWith(".json")){
                continue;
            }
            fontName = fontName.replaceAll("[.][^.]+$","");
            fontContent = FileUtil.readFile(fontFile.getAbsolutePath());
            if(StringUtils.isNotBlank(fontContent)){
                fontJson = JSONObject.parseObject(fontContent);
                fonts.put(fontName,fontJson);
                log.info("加载字体缓存：" + fontName);
            }
        }
    }

    /**
     * Gets cache.
     *
     * @param params the FontBean
     * @return the cache
     */
    @Override
    public Object getCache(Object params) {
        if(null == params || !(params instanceof FontBean)){
            return null;
        }
        FontBean fontBean = (FontBean)params;
        JSONObject font = fonts.get(fontBean.getFontType() + ICommonConstants.PROPERTY_CONNECTOR + fontBean.getFontWeight());
        if(null == font){
            return null;
        }
        JSONObject glyphs = font.getJSONObject("glyphs");
        JSONObject result = new JSONObject();
        String searchParams = fontBean.getFontSearchParams();
        if(StringUtils.isNotBlank(searchParams)){
            char[] paramChars = searchParams.toCharArray();
            for (char param : paramChars) {
                result.put(String.valueOf(param),glyphs.get(String.valueOf(param)));
            }
        }
        return result;
    }

}
