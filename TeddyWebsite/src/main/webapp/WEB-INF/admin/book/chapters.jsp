<%--
  Created by IntelliJ IDEA.
  User: tingyu
  Date: 2017/4/16
  Time: 17:36
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
    <title>Chapters</title>

    <link href="${base}/hplus/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="${base}/hplus/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${base}/hplus/css/animate.min.css" rel="stylesheet">
    <link href="${base}/hplus/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="${base}/css/common.css" rel="stylesheet">
    <link href="${base}/css/admin/book/chapter.css" rel="stylesheet">
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div id="book" data-id="${bookId}" class="col-xs-12 col-sm-3 col-md-3 animated fadeInLeft">
        <div class="list-group">
            <div href="#" class="list-group-item clear-border border-bottom">
                <h4 class="list-group-item-heading">作品名称</h4>
                <p class="list-group-item-text">{{book.cBookName}}</p>
            </div>
            <div href="#" class="list-group-item clear-border border-bottom">
                <h4 class="list-group-item-heading">作品类型</h4>
                <p class="list-group-item-text">
                    <span class="code" data-code-type="10100002" :data-code-value="book.nBookType"></span>
                </p>
            </div>
            <div href="#" class="list-group-item clear-border border-bottom">
                <h4 class="list-group-item-heading">作品标签</h4>
                <p class="list-group-item-text">{{book.cBookLabel}}</p>
            </div>
            <div href="#" class="list-group-item clear-border border-bottom">
                <h4 class="list-group-item-heading">写作状态</h4>
                <p class="list-group-item-text">
                    <span class="code" data-code-type="10100003" :data-code-value="book.nPublishState"></span>
                </p>
            </div>
            <div href="#" class="list-group-item clear-border border-bottom">
                <h4 class="list-group-item-heading">作品简介</h4>
                <p class="list-group-item-text">{{book.cBookIntro}}</p>
            </div>
        </div>
    </div>
    <div id="chapters" data-page-size="10" class="col-xs-12 col-sm-9 col-md-9 animated fadeInRight">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12">
                <div class="file-box" v-on:click="addChapter()">
                    <div class="file">
                        <div>
                            <span class="corner"></span>
                            <div class="icon">
                                <i class="fa fa-plus"></i>
                            </div>
                            <div class="file-name">
                                <span class="text-center">添加一个新章节</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div v-for="chapter in chapters">
                    <div class="file-box" v-on:click="editChapter(chapter.cId)">
                        <div class="file">
                            <div>
                                <span class="corner"></span>
                                <div class="icon">
                                    <i class="fa fa-file"></i>
                                </div>
                                <div class="file-name">
                                    <span>{{chapter.cChapterName}}</span>
                                    <br/>
                                    <small>添加时间：{{chapter.dtCreateTime}}</small>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="chapter" class="col-xs-12 col-sm-9 col-md-9 hidden">
        <div id="chapterContent" class="row">
            <button id="chapter-close" class="btn btn-block btn-outline btn-primary" onclick="hideChapter()"><span class="fa fa-chevron-right"></span></button>
            <div class="jumbotron">
                <h3 class="paragraph">
                    发表作品中不得含有违法违规信息，包括但不限于淫秽色情、反动、违背主流道德观等有害信息。如发现作品中含有违法违规内容，将对违法违规作品进行删除处理，冻结作者账号并保留追究作者法律责任的权利。请各位作者自觉自律，切勿以身试法，共建和谐文明的网络环境。
                </h3>
            </div>
            <div class="col-xs-12 col-xs-offset-0 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 clearfix">
                <form id="chapter-info" class="form-horizontal">
                    <div>
                        <input type="hidden" name="chapter-id" data-submit-name="chapter.cId" :value="chapter.cId" data-submit-name="chapter.cId">
                    </div>
                    <div class="form-group">
                        <label for="chapter-volume" class="col-xs-2 col-sm-2 col-md-2 control-label required">卷名称</label>
                        <div class="col-xs-10 col-sm-10 col-md-10">
                            <input type="text" class="form-control" :value="chapter.cVolume" id="chapter-volume" name="chapter-volume"
                                   data-submit-name="chapter.cVolume" placeholder="卷名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="chapter-name" class="col-xs-2 col-sm-2 col-md-2 control-label required">章节名称</label>
                        <div class="col-xs-10 col-sm-10 col-md-10">
                            <input type="text" class="form-control" :value="chapter.cChapterName" id="chapter-name" name="chapter-name"
                                   data-submit-name="chapter.cChapterName" placeholder="章节名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="chapter-intro" class="col-xs-2 col-sm-2 col-md-2 control-label required">章节简介</label>
                        <div class="col-xs-10 col-sm-10 col-md-10">
                            <textarea id="chapter-intro" class="form-control" name="chapter-intro" data-submit-name="chapter.cChapterIntro"
                                      v-text="chapter.cChapterIntro" rows="3" placeholder="章节简介"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="chapter-content" class="col-xs-2 col-sm-2 col-md-2 control-label required">章节内容</label>
                        <div class="col-xs-10 col-sm-10 col-md-10">
                            <script id="chapter-content" type="text/plain" style="height: 500px;width:100%;"></script>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-5 col-sm-5 col-md-5 pull-right">
                            <button id="publishButton" type="button" class="btn btn-block btn-outline btn-primary btn-lg" onclick="publishChapter()">
                                <i class="fa fa-spinner fa-spin hidden"></i>
                                发布
                            </button>
                        </div>
                        <div class="col-xs-5 col-sm-5 col-md-5 pull-right">
                            <button id="saveButton" type="button" class="btn btn-block btn-outline btn-primary btn-lg" onclick="saveChapter()">
                                <i class="fa fa-spinner fa-spin hidden"></i>
                                暂存
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="${base}/hplus/js/jquery.min.js?v=2.1.4"></script>
<script src="${base}/hplus/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${base}/hplus/js/content.min.js?v=1.0.0"></script>
<script src="${base}/hplus/js/plugins/suggest/bootstrap-suggest.min.js"></script>
<script src="${base}/hplus/js/plugins/validate/jquery.validate.min.js"></script>
<script src="${base}/hplus/js/plugins/layer/layer.min.js"></script>
<script src="${base}/js/common/CommonConstants.js"></script>
<script src="${base}/js/lib/vue.min.js"></script>
<script src="${base}/js/common/CommonVue.js"></script>
<script src="${base}/js/common/CommonUtils.js"></script>
<script src="${base}/ueditor/ueditor.config.js"></script>
<script src="${base}/ueditor/ueditor.all.min.js"></script>
<script src="${base}/ueditor/lang/zh-cn/zh-cn.js"></script>
<script src="${base}/js/admin/book/chapters.js"></script>
</body>
</html>
