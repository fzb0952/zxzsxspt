<%--
  Created by IntelliJ IDEA.
  User: tingyu
  Date: 2017/3/15
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
    <base id="base" data-href="${pageContext.request.contextPath}">
    <c:set var="base" value="${pageContext.request.contextPath}"></c:set>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="${base}/favicon.ico" />
    <link rel="bookmark" href="${base}/favicon.ico" type="image/x-icon"　/>
    <title>MyAddress</title>
    <link rel="stylesheet" href="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.css" />
    <link rel="stylesheet" href="${base}/bootstrap/dist/css/bootstrap.min.css">

    <style>
        /* 百度地图样式 */
        .iw_poi_title {color:#CC5522;font-size:14px;font-weight:bold;overflow:hidden;padding-right:13px;white-space:nowrap}
        .iw_poi_content {font:12px arial,sans-serif;overflow:visible;padding-top:4px;white-space:-moz-pre-wrap;word-wrap:break-word}
        .BMapLib_sendToPhone{display: none !important;}
    </style>
</head>
<body>
<div id="my-address" style="position: absolute;top: 0px;left: 0px;right: 0px;bottom: 0px;"></div>

<script src="${base}/js/lib/jquery-1.12.2.min.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=2f133f5144045f2d893db99af0252d57"></script>
<script type="text/javascript" src="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.js"></script>
<script src="${base}/js/introduction/myAddressMap.js"></script>
</body>
</html>
