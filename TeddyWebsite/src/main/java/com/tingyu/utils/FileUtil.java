package com.tingyu.utils;


import com.tingyu.common.ICommonConstants;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by tingyu on 2017/2/26.
 */
public class FileUtil {
    private static Log log = LogFactory.getLog(FileUtil.class);
    /**
     * Get webapp path string.
     *
     * @return the string
     */
    public static String getWebappPath(){
        return System.getProperty("evan.TeddyWebsite");
    }

    /**
     * Read file string.
     *
     * @param fileName the file name
     * @return the string
     */
    public static String readFile(String fileName){
        BufferedReader reader = null;
        StringBuffer fileContent = new StringBuffer();
        String tempString;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
            // 一次读入一行，直到读入null为文件结束
            char[] readBuffer = new char[1024];
            while (reader.read(readBuffer) != -1) {
                fileContent.append(String.valueOf(readBuffer));
                readBuffer = new char[1024];
            }
            reader.close();
        } catch (IOException e) {
            log.error("读取文件失败!",e);
            return null;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    log.error("关闭文件流失败!",e1);
                }
            }
        }
        return fileContent.toString();
    }

    /**
     * 根据key获取配置文件的配置内容
     * @param key
     * @return String
     */
    public static String getPropsConfig(String key){
        InputStream inputStream = FileUtil.class.getClassLoader().getResourceAsStream(getWebappPath() +
                File.separator + "WEB-INF/classes/config/");
        Properties p = new Properties();
        try {
            p.load(inputStream);
            inputStream.close();
        } catch (IOException e1) {
            log.error("读取配置文件失败!",e1);
            return null;
        }
        return p.getProperty(key);
    }

    public static List<String> unzip(String zipPath, String destPath){
        List<String> listUnzip = new ArrayList<String>();
        ZipFile zFile;
        try {
            zFile = new ZipFile(zipPath);   // 首先创建ZipFile指向磁盘上的.zip文件
            if (!zFile.isValidZipFile()) {   // 验证.zip文件是否合法，包括文件是否存在、是否为zip文件、是否被损坏等
                throw new ZipException("压缩文件不合法,可能被损坏.");
            }
            File destDir = new File(destPath);     // 解压目录
            if (destDir.isDirectory() && !destDir.exists()) {
                destDir.mkdir();
            }

            // 将文件抽出到解压目录(解压)
            @SuppressWarnings("unchecked")
            List<FileHeader> list = zFile.getFileHeaders();
            for (FileHeader fileHeader : list) {
                String newFileName = fileHeader.getFileName();
                zFile.extractFile(fileHeader,destPath,null,newFileName);
                listUnzip.add(destPath + File.separator + newFileName);
            }
        } catch (ZipException e) {
            log.error("文件解压失败!" , e);
            return null;
        }
        return listUnzip;
    }

    /**
     * 根据文件名删除文件
     * @param fileName
     * @return
     */
    public static boolean deleteFileByName(String fileName){
        File file = new File(fileName);
        return file.delete();
    }

    /**
     * 移动文件到指定目录
     * @param pathname
     * @param movePath
     * @return
     */
    public static boolean moveFile(String pathname,String movePath){
        boolean bResult = false;
        File file = new File(pathname);
        if(file.exists()){
            try {
                bResult = file.renameTo(new File(movePath + File.separator + file.getName()));
            } catch (Exception e) {
                log.error(e);
            }
        }
        return bResult;
    }

    /**
     * 判断某个路径是否为空
     * @param path
     * @return boolean
     */
    public static boolean isEmptyPath(String path){
        File file = new File(path);
        File[] files = file.listFiles();
        return files.length > 0 ? false : true;
    }
}
