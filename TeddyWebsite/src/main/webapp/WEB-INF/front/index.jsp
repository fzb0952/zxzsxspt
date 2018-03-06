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
    <title>Teddy's blog</title>

    <link rel="stylesheet" href="${base}/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${base}/hplus/css/plugins/sweetalert/sweetalert.css">
    <link rel="stylesheet" href="${base}/css/index.css">
    <link rel="stylesheet" href="${base}/css/common.css">
</head>
<body>
<div class="container">
    <nav id="navbar" class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button id="nav-collapse" type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#navbar-collapse" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Teddy's blog</a>
            </div>
            <div class="collapse navbar-collapse" id="navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="${pageId == null || pageId == 'home' ? 'active' : ''}">
                        <a href="${base}/front/home" target="content">首页<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="${pageId == 'introduction' ? 'active' : ''}">
                        <a href="${base}/front/introduction" target="content">自我介绍</a>
                    </li>
                    <li class="${pageId == 'lifeStory' ? 'active' : ''}">
                        <a href="${base}/front/lifeStory" target="content">生活感悟</a>
                    </li>
                    <li><a href="#">学习成长</a></li>
                    <li><a href="#">留言板</a></li>
                    <li><a href="#">书库</a></li>
                </ul>
                <form class="navbar-form navbar-right" role="search">
                    <div class="form-group  has-feedback" >
                        <input type="text" class="form-control" placeholder="Search" id="search" aria-describedby="search2Status">
                        <span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true"></span>
                        <span id="search2Status" class="sr-only">(success)</span>
                    </div>
                </form>
            </div>

        </div>
    </nav>

    <div id="content" class="row">
        <iframe id="content-frame" name="content" src="${base}/front/${null == pageId ? "home" : pageId}" scrolling="no"
                height="100%" width="100%" frameborder="0"></iframe>
    </div>

    <!-- footer -->
    <div id="footer" class="row well">
        <div>Copyright © 2017<span id="copyright-year-end" class="hidden"></span> by Teddy. All rights reserved.</div>
        <div>Design by 范中伟&nbsp;&nbsp;&nbsp;<a target="_blank" href="http://www.beianbeian.com/search/fanzhongwei.com">蜀ICP备17004833号-1</a></div>
    </div>
</div>

<script src="${base}/js/lib/jquery-1.12.2.min.js"></script>
<script src="${base}/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="${base}/hplus/js/plugins/sweetalert/sweetalert.min.js"></script>

<script src="${base}/js/common/CommonUtils.js"></script>
<script src="${base}/js/index.js"></script>
</body>
</html>