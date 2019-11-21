<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="itcast" uri="http://itcast.cn/common/"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>测试页面</title>
    <script type="text/javascript" src="<%=basePath%>/resource/js/quote/jquery-2.1.1.min.js" ></script>
</head>
<body>
<br/>
<ul>
    <li><a href="/empSingleAdd">单个新增</a></li>
    <li><a href="/empAdd">批量新增</a></li>
    <li><a href="/empSingleUpdate">单个修改</a></li>
    <li><a href="/empUpdate">批量修改</a></li>
    <li><a href="/baseDetailAdd">一对多批量新增</a></li>
</ul>
</body>
</html>
