<%--
  Created by IntelliJ IDEA.
  User: tingyu
  Date: 2017/4/3
  Time: 21:43
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
    <title>新建作品</title>

    <link href="${base}/hplus/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="${base}/hplus/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${base}/hplus/css/animate.min.css" rel="stylesheet">
    <link href="${base}/hplus/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="${base}/css/common.css" rel="stylesheet">
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="jumbotron">
        <h3 class="paragraph">
            发表作品中不得含有违法违规信息，包括但不限于淫秽色情、反动、违背主流道德观等有害信息。如发现作品中含有违法违规内容，将对违法违规作品进行删除处理，冻结作者账号并保留追究作者法律责任的权利。请各位作者自觉自律，切勿以身试法，共建和谐文明的网络环境。
        </h3>
    </div>
    <div class="row">
        <div class="col-xs-12 col-xs-offset-0 col-sm-6 col-sm-offset-3 col-md-6 col-md-offset-3">
            <form id="create-book" class="form-horizontal">
                <div>
                    <input type="hidden" name="book-id" data-submit-name="book.cId" value="${book.cId}">
                </div>
                <div class="form-group">
                    <label for="book-name" class="col-xs-2 col-sm-2 col-md-2 control-label required">作品名称</label>
                    <div class="col-xs-10 col-sm-10 col-md-10">
                        <input type="text" class="form-control" value="${book.cBookName}" id="book-name" name="book-name"
                               data-submit-name="book.cBookName" placeholder="作品名称">
                    </div>
                </div>
                <div class="form-group">
                    <label for="book-type" class="col-xs-2 col-sm-2 col-md-2 control-label required">作品类型</label>
                    <div class="col-xs-10 col-sm-10 col-md-10">
                        <div class="input-group">
                            <input class="form-control code" data-code="10100002" data-id="${book.nBookType}" data-code-name="作品类型"
                                   data-submit-name="book.nBookType" id="book-type" name="book-type" placeholder="请选择作品类型">
                            <div class="input-group-btn">
                                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><span class="caret"></span></button>
                                <ul class="dropdown-menu">
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="book-label" class="col-xs-2 col-sm-2 col-md-2 control-label">作品标签</label>
                    <div class="col-xs-10 col-sm-10 col-md-10">
                        <div class="input-group">
                            <input class="form-control" value="${book.cBookLabel}" id="book-label" name="book-label" data-submit-name="book.cBookLabel" placeholder="请选择作品标签">
                            <div class="input-group-btn">
                                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><span class="caret"></span></button>
                                <ul class="dropdown-menu">
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="book-state" class="col-xs-2 col-sm-2 col-md-2 control-label required">写作状态</label>
                    <div class="col-xs-10 col-sm-10 col-md-10">
                        <div id="book-state" class="checkbox code" data-code="10100003">
                            <label>
                                <input type="radio" name="book-state" value="1" ${book.nPublishState == 1 ? 'checked':''} data-submit-name="book.nPublishState"> 连载中
                            </label>
                            <label>
                                <input type="radio" name="book-state" value="2" ${book.nPublishState == 2 ? 'checked':''}  data-submit-name="book.nPublishState"> 已完结
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="book-intro" class="col-xs-2 col-sm-2 col-md-2 control-label required">作品简介</label>
                    <div class="col-xs-10 col-sm-10 col-md-10">
                        <textarea id="book-intro" class="form-control" name="book-intro" data-submit-name="book.cBookIntro" rows="6">${book.cBookIntro}</textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-10 col-sm-10 col-md-10 pull-right">
                        <button type="button" class="btn btn-block btn-outline btn-primary btn-lg ${book == null ? '' : 'hidden'}" onclick="addBook(this)">
                            <i class="fa fa-spinner fa-spin hidden"></i>
                            创建
                        </button>
                        <button type="button" class="btn btn-block btn-outline btn-primary btn-lg ${book == null ? 'hidden' : ''}" onclick="editBook(this)">
                            <i class="fa fa-spinner fa-spin hidden"></i>
                            保存
                        </button>
                    </div>
                </div>
            </form>
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
<script src="${base}/js/common/CommonUtils.js"></script>
<script src="${base}/js/admin/book/create-book.js"></script>
</body>
</html>
