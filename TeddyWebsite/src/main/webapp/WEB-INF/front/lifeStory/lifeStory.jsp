<%--
  Created by IntelliJ IDEA.
  User: tingyu
  Date: 2017/3/23
  Time: 21:39
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
    <link rel="shortcut icon" href="/favicon.ico"/>
    <link rel="bookmark" href="/favicon.ico" type="image/x-icon" 　/>
    <title>Life Story</title>

    <link rel="stylesheet" href="${base}/bootstrap/dist/css/bootstrap.min.css">
    <link href="${base}/hplus/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${base}/hplus/css/animate.min.css" rel="stylesheet">
    <link href="${base}/hplus/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="${base}/css/common.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-12">
            <div class="wrapper wrapper-content">
                <div class="row animated fadeInRight">
                    <div class="col-sm-12">
                        <div class="ibox float-e-margins">
                            <div class="text-center float-e-margins p-md">
                                <span>切换风格：</span>
                                <a href="#" class="btn btn-xs btn-primary" id="lightVersion">浅色</a>
                                <a href="#" class="btn btn-xs btn-primary" id="darkVersion">深色</a>
                                <a href="#" class="btn btn-xs btn-primary" id="leftVersion">布局切换</a>
                            </div>
                            <div class="" id="ibox-content">

                                <div id="vertical-timeline" class="vertical-container light-timeline">
                                    <div class="vertical-timeline-block">
                                        <div class="vertical-timeline-icon navy-bg">
                                            <i class="fa fa-briefcase"></i>
                                        </div>

                                        <div class="vertical-timeline-content">
                                            <h2>会议</h2>
                                            <p>上一年的销售业绩发布会。总结产品营销和销售趋势及销售的现状。
                                            </p>
                                            <a href="#" class="btn btn-sm btn-primary"> 更多信息</a>
                                            <span class="vertical-date">
                                        今天 <br>
                                        <small>2月3日</small>
                                    </span>
                                        </div>
                                    </div>

                                    <div class="vertical-timeline-block">
                                        <div class="vertical-timeline-icon blue-bg">
                                            <i class="fa fa-file-text"></i>
                                        </div>

                                        <div class="vertical-timeline-content">
                                            <h2>给张三发送文档</h2>
                                            <p>发送上年度《销售业绩报告》</p>
                                            <a href="#" class="btn btn-sm btn-success"> 下载文档 </a>
                                            <span class="vertical-date">
                                        今天 <br>
                                        <small>2月3日</small>
                                    </span>
                                        </div>
                                    </div>

                                    <div class="vertical-timeline-block">
                                        <div class="vertical-timeline-icon lazur-bg">
                                            <i class="fa fa-coffee"></i>
                                        </div>

                                        <div class="vertical-timeline-content">
                                            <h2>喝咖啡休息</h2>
                                            <p>喝咖啡啦，啦啦啦~~</p>
                                            <a href="#" class="btn btn-sm btn-info">更多</a>
                                            <span class="vertical-date"> 昨天 <br><small>2月2日</small></span>
                                        </div>
                                    </div>

                                    <div class="vertical-timeline-block">
                                        <div class="vertical-timeline-icon yellow-bg">
                                            <i class="fa fa-phone"></i>
                                        </div>

                                        <div class="vertical-timeline-content">
                                            <h2>给李四打电话</h2>
                                            <p>给李四打电话分配本月工作任务</p>
                                            <span class="vertical-date">昨天 <br><small>2月2日</small></span>
                                        </div>
                                    </div>

                                    <div class="vertical-timeline-block">
                                        <div class="vertical-timeline-icon lazur-bg">
                                            <i class="fa fa-user-md"></i>
                                        </div>

                                        <div class="vertical-timeline-content">
                                            <h2>公司年会</h2>
                                            <p>发年终奖啦，啦啦啦~~</p>
                                            <span class="vertical-date">前天 <br><small>2月1日</small></span>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>

<script src="${base}/js/lib/jquery-1.12.2.min.js"></script>
<script src="${base}/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="${base}/js/lifeStory/lifeStory.js"></script>
</body>
</html>
