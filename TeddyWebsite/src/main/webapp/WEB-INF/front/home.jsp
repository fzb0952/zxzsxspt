<%--
  Created by IntelliJ IDEA.
  User: tingyu
  Date: 2017/3/4
  Time: 12:01
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
    <title>home</title>

    <link rel="stylesheet" href="${base}/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${base}/hplus/css/animate.min.css">
    <link rel="stylesheet" href="${base}/css/home/home.css">
    <link rel="stylesheet" href="${base}/css/common.css">
</head>
<body onload="main()">
<div class="container-fluid">
    <!-- 图片轮播 -->
    <div class="row animated bounceIn">
        <div id="carousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#carousel" data-slide-to="0" class="active"></li>
                <li data-target="#carousel" data-slide-to="1"></li>
                <li data-target="#carousel" data-slide-to="2"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">
                <div id="particel" class="item carousel-index active">
                </div>
                <div class="item carousel-index">
                    <img src="${base}/images/fitness.jpg">
                    <div class="carousel-caption">
                        Change your body,change your mind.
                    </div>
                </div>
                <div class="item carousel-index">
                    <img src="${base}/images/fitness.jpg">
                    <div class="carousel-caption">
                        人生唯有读书与健身不能辜负
                    </div>
                </div>
            </div>

            <!-- Controls -->
            <a class="left carousel-control" href="#carousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#carousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>

    <div class="row content">
        <div id="content-left" class="col-xs-12 col-sm-8 col-md-9 animated fadeInLeft">
            <c:forEach var="i" begin="0" end="6" step="1">
                <div class="row title-info">
                    <h3>JavaScript事件绑定时的this和传参问题</h3>
                    <span>发布时间：<span>2017-03-04</span></span>
                    <span>作者：<span>Teddy</span></span>
                    <span>标签：【<a href="#"><span>学习分享</span></a>】</span>
                </div>
                <div class="row">
                    <div class="col-xs-5 col-md-2">
                        <a href="http://www.cnblogs.com/tingyu-blog/p/6212392.html" target="_blank"  class="thumbnail">
                            <img src="${base}/images/bind.jpg">
                        </a>
                    </div>
                    <div class="col-xs-7 col-md-10">
                        <p class="paragraph">使用call、apply和bind改变函数执行时的上下文（this）使用call、apply和bind改变函数执行时的上下文（this）使用call、apply和bind改变函数执行时的上下文（this）使用call、apply和bind改变函数执行时的上下文（this）</p>
                        <p class="more pull-right"><a href="http://www.cnblogs.com/tingyu-blog/p/6212392.html" target="_blank" class="btn btn-link">更多>></a></p>
                    </div>
                </div>
                <div class="parting-line"></div>
            </c:forEach>
        </div>
        <div id="content-right" class="col-xs-4 col-sm-4 col-md-3 animated fadeInRight">
            <div class="panel panel-default">
                <div class="panel-heading">
                    最新发布
                    <span class="label label-info pull-right">new</span>
                </div>
                <div class="panel-body recent-publish clear-padding">
                    <div class="list-group clear-margin">
                        <c:forEach var="i" begin="1" end="10">
                            <a href="http://www.cnblogs.com/tingyu-blog/p/6212392.html" target="_blank" class="list-group-item"
                               data-toggle="tooltip" data-placement="bottom" title="JavaScript事件绑定时的this和传参问题">
                                <span class="badge pull-left">${i}</span>JavaScript事件绑定时的this和传参问题
                            </a>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    点击排行
                    <span class="label label-danger pull-right">
                        <span class="glyphicon glyphicon-fire"></span>
                    </span>
                </div>
                <div class="panel-body hot-list clear-padding">
                    <div class="list-group clear-margin">
                        <c:forEach var="i" begin="1" end="10" step="1">
                            <a href="http://www.cnblogs.com/tingyu-blog/p/6212392.html" target="_blank" class="list-group-item"
                            data-toggle="tooltip" data-placement="bottom" title="JavaScript事件绑定时的this和传参问题">
                                <span class="badge pull-left">${i}</span>JavaScript事件绑定时的this和传参问题
                            </a>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<script src="${base}/js/lib/jquery-1.12.2.min.js"></script>
<script src="${base}/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="${base}/js/lib/Threejs/three.min.js"></script>
<script src="${base}/js/lib/Threejs/tween.min.js"></script>
<script src="${base}/js/lib/Threejs/CanvasRenderer.js"></script>
<script src="${base}/js/lib/Threejs/Projector.js"></script>
<script src="${base}/hplus/js/plugins/sweetalert/sweetalert.min.js"></script>

<script src="${base}/js/home/particle.js"></script>
<script src="${base}/js/home/threeText.js"></script>
<script src="${base}/js/home/render.js"></script>
<script src="${base}/js/common/CommonUtils.js"></script>
<script src="${base}/js/home/home.js"></script>
</body>
</html>
