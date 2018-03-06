<%--
  Created by IntelliJ IDEA.
  User: tingyu
  Date: 2017/4/3
  Time: 18:32
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
    <title>My Book</title>

    <link href="${base}/hplus/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="${base}/hplus/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${base}/hplus/css/animate.min.css" rel="stylesheet">
    <link href="${base}/hplus/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="${base}/css/common.css" rel="stylesheet">
    <link href="${base}/css/admin/book/index.css" rel="stylesheet">
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="col-xs-12 col-sm-3 col-md-3 animated fadeInLeft">
        <div class="ibox float-e-margins">
            <div class="ibox-content">
                <div class="file-manager">
                    <h5>显示：</h5>
                    <a href="#" class="file-control active">所有</a>
                    <a href="#" class="file-control">文档</a>
                    <a href="#" class="file-control">视频</a>
                    <a href="#" class="file-control">图片</a>
                    <div class="hr-line-dashed"></div>
                    <button class="btn btn-primary btn-block" onclick="createBook()">新建作品</button>
                    <div class="hr-line-dashed"></div>
                    <h5>作品分类</h5>
                    <ul class="folder-list" style="padding: 0">
                        <li><a href="#"><i class="fa fa-folder"></i>哲学类</a></li>
                        <li><a href="#"><i class="fa fa-folder"></i>社会科学类</a></li>
                        <li><a href="#"><i class="fa fa-folder"></i>政治类</a></li>
                        <li><a href="#"><i class="fa fa-folder"></i>法律类</a></li>
                        <li><a href="#"><i class="fa fa-folder"></i>军事类</a></li>
                        <li><a href="#"><i class="fa fa-folder"></i>经济类</a></li>
                    </ul>
                    <h5 class="tag-title">标签</h5>
                    <ul class="tag-list" style="padding: 0">
                        <li><a href="#">爱人</a></li>
                        <li><a href="#">工作</a></li>
                        <li><a href="#">家庭</a></li>
                        <li><a href="#">孩子</a></li>
                        <li><a href="#">假期</a></li>
                        <li><a href="#">音乐</a></li>
                        <li><a href="#">照片</a></li>
                        <li><a href="#">电影</a></li>
                    </ul>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-xs-12 col-sm-9 col-md-9 animated fadeInRight">
        <div class="row">
            <div id="books" data-page-size="10" class="col-xs-12 col-sm-12 col-md-12">
                <div v-for="book in books">
                    <div class="file-box">
                        <i class="fa fa-pencil edit" v-on:click="editBook(book.cId)"></i>
                        <a :href="'${base}/admin/chapters?bookId=' + book.cId" target="_self">
                            <div class="file">
                                <div>
                                    <span class="corner"></span>
                                    <div class="icon">
                                        <i class="fa fa-file"></i>
                                    </div>
                                    <div class="file-name">
                                        <span>{{book.cBookName}}</span>
                                        <br/>
                                        <small>添加时间：{{book.dtCreateTime}}</small>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="${base}/hplus/js/jquery.min.js?v=2.1.4"></script>
<script src="${base}/hplus/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${base}/hplus/js/content.min.js?v=1.0.0"></script>
<script src="${base}/hplus/js/plugins/layer/layer.min.js"></script>
<script src="${base}/js/lib/vue.min.js"></script>
<script src="${base}/js/common/CommonConstants.js"></script>
<script src="${base}/js/common/CommonUtils.js"></script>
<script src="${base}/js/common/CommonVue.js"></script>
<script src="${base}/js/admin/book/index.js"></script>
</body>
</html>
