<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--<link rel="shortcut icon" href="../images/logo.png" type="image/x-icon"/>-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/frontAssets/jquery.mobile/jquery.mobile-1.4.5.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/frontAssets/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/frontAssets/css/login.css">
    <title>操作成功</title>
</head>
<body>
<div data-role="page">

    <!--公共头部-->
    <div data-role="header" class="fixed-header">
        <a href="#" class="ui-btn" data-ajax="false" data-rel="back">返回</a>
        <h1>操作成功</h1>
    </div>


    <div data-role="main" class="ui-content">
        <div style="padding: 5px 10px">
            <c:if test="${orders!=null}">
                该订单于${orders.shopOrderTimeToString()}完成下单，订单号为${orders.shopOrderId}，已
            </c:if><span style="color: red">${message}</span>！
        </div>
    </div>

    <!--公共底部-->

</div>


<script src="${pageContext.request.contextPath}/frontAssets/js/common/jquery.min.js" rel="script"></script>
<script src="${pageContext.request.contextPath}/frontAssets/jquery.mobile/jquery.mobile-1.4.5.min.js" rel="script"></script>

</body>
</html>