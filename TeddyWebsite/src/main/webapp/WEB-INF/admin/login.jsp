<%--
  Created by IntelliJ IDEA.
  User: tingyu
  Date: 2017/4/2
  Time: 9:56
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
    <link rel="shortcut icon" href="${base}/favicon.ico"/>
    <link rel="bookmark" href="${base}/favicon.ico" type="image/x-icon" 　/>
    <title>Login</title>

    <link href="${base}/hplus/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="${base}/hplus/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${base}/hplus/css/animate.min.css" rel="stylesheet">
    <link href="${base}/hplus/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="${base}/css/admin/login.css" rel="stylesheet">

</head>
<body class="gray-bg">
<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div>
        <div>
            <h3 class="logo-name">Teddy</h3>
        </div>
        <form id="login-form" class="m-t" role="form" method="post" action="${base}/admin/login">
            <div class="form-group">
                <div class="input-group">
                    <input id="username" name="username" type="email" class="form-control" value="${username}" placeholder="username" autocomplete="off">
                    <div class="input-group-btn">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Action <span class="caret"></span></button>
                        <ul id="username-suggest" class="dropdown-menu">
                        </ul>
                    </div><!-- /btn-group -->
                </div>
            </div>
            <div class="form-group">
                <input type="password" name="password" class="form-control" placeholder="password" value="${password}" autocomplete="off">
            </div>
            <div class="${error == null ? 'hidden':''} has-error">
                <span class="help-block">${error}</span>
            </div>
            <button type="submit" class="btn btn-primary block full-width m-b">Login</button>
            <p class="text-muted text-center">
                <a href="#">
                    <small>忘记密码了？</small>
                </a>
            </p>
        </form>
    </div>
</div>
<script src="${base}/hplus/js/jquery.min.js?v=2.1.4"></script>
<script src="${base}/hplus/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${base}/hplus/js/plugins/validate/jquery.validate.min.js"></script>
<script src="${base}/hplus/js/plugins/suggest/bootstrap-suggest.min.js"></script>
<script src="${base}/js/common/CommonUtils.js"></script>
<script src="${base}/js/admin/login.js"></script>
</body>
</html>
