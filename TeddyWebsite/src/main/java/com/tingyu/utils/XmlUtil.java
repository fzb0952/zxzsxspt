package com.tingyu.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 *
 * ClassName: GyXmlUtil
 * @Description: 公用XML工具类
 * @author fanzhongwei
 * @version 1.0
 *
 * @date 2017-5-9
 */
public class XmlUtil {
    /** 日志记录 */
    private static Log logger = LogFactory.getLog(XmlUtil.class);

    /**
     *
     * Description: 根据xml文件名获取document对象
     * @param fileName String
     * @return
     * Document
     * @throws
     *
     * @author fanzhongwei
     * @date 2017-5-9
     */
    public static Document getDocByFileName(String fileName) {
        SAXReader reader = new SAXReader();
        FileInputStream fis = null;
        Document document = null;
        try {
            fis = new FileInputStream(fileName);
            document = reader.read(fis);
        } catch (DocumentException e) {
            logger.error("打开Xml文件:" + fileName + "失败！", e);
        } catch (FileNotFoundException e) {
            logger.error("Xml文件:" + fileName + "不存在！", e);
        } finally {
            if (null != fis) {
                try {
                    fis.close();
                } catch (IOException e) {
                    logger.error("将文件[" + fileName + "]转换成Document,输入流关闭异常", e);
                }
            }
        }
        return document;
    }

    /**
     * Description: 查询XML节点的text
     * @param doc Node
     * @param xPath String
     * @return
     * String
     * @throws
     *
     * @author fanzhongwei
     * @date 2017-5-9
     */
    public static String queryValueFromNode(Node doc, String xPath) {
        Node node = doc.selectSingleNode(xPath);
        if (node == null) {
            return "";
        }
        return node.getText();
    }

    /**
     *
     * Description: 查询指定节点
     * @param doc Node
     * @param xPath String
     * @return
     * Node
     * @throws
     *
     * @author fanzhongwei
     * @date 2017-5-9
     */
    public static Node queryNode(Node doc, String xPath) {
        return doc.selectSingleNode(xPath);
    }

    /**
     * Description: 查询所有满足条件的XML节点的text
     * @param doc Node
     * @param xPath String
     * @return
     * List<String>
     * @throws
     *
     * @author fanzhongwei
     * @date 2017-5-9
     */
    @SuppressWarnings("unchecked")
    public static List<String> queryValuesFromNode(Node doc, String xPath) {
        List<Node> list = doc.selectNodes(xPath);
        List<String> result = new ArrayList<String>(list.size());
        for (Node e : list) {
            result.add(e.getText());
        }
        return result;
    }

    /**
     * Description: 查询所有满足条件的XML节点
     * @param doc Node
     * @param xPath String
     * @return
     * List<Node>
     * @throws
     *
     * @author fanzhongwei
     * @date 2017-5-9
     */
    @SuppressWarnings("unchecked")
    public static List<Node> queryNodesFromNode(Node doc, String xPath) {
        List<Node> list = doc.selectNodes(xPath);
        return list;
    }

    /**
     *
     * Description: 获取Node中指定节点的attribute值
     * @param doc Node
     * @param xPath String
     * @param attributeName String
     * @return
     * String
     * @throws
     *
     * @author fanzhongwei
     * @date 2017-5-9
     */
    public static String queryAttributeFromNode(Node doc, String xPath, String attributeName) {
        Node node = doc.selectSingleNode(xPath);
        if (node == null) {
            return "";
        }
        return ((Element) node).attributeValue(attributeName);
    }
}
