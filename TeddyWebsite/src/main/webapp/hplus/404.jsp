<%--
  Created by IntelliJ IDEA.
  User: tingyu
  Date: 2017/3/19
  Time: 19:39
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
    <title>404</title>

    <link href="${base}/hplus/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="${base}/hplus/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">

    <link href="${base}/hplus/css/animate.min.css" rel="stylesheet">
    <link href="${base}/hplus/css/style.min862f.css?v=4.1.0" rel="stylesheet">
</head>
<body class="gray-bg">
<div class="middle-box text-center animated fadeInDown">
    <h1>404</h1>
    <h3 class="font-bold">页面未找到！</h3>

    <div class="error-desc">
        抱歉，页面好像去火星了~
        <form class="form-inline m-t" role="form">
            <div class="form-group">
                <input type="email" class="form-control" placeholder="请输入您需要查找的内容 …">
            </div>
            <button type="submit" class="btn btn-primary">搜索</button>
        </form>
    </div>
</div>
<script src="${base}/hplus/js/jquery.min.js?v=2.1.4"></script>
<script src="${base}/hplus/js/bootstrap.min.js?v=3.3.6"></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

<script>
    $(document).ready(function () {
        if (top.location != self.location) {
            top.location = self.location;
        }
    });
</script>
</body>
</html>
