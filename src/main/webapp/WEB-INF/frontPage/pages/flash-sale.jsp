<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/frontAssets/images/logo.jpg" type="image/x-icon"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/frontAssets/jquery.mobile/jquery.mobile-1.4.5.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/frontAssets/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/frontAssets/css/flash-sale.css">
    <title>限时秒杀</title>
</head>
<body>
<div data-role="page">

    <!--公共头部-->
    <div data-role="header" class="fixed-header">
        <a href="#" class="ui-btn" style="visibility: hidden"></a>
        <img src="${pageContext.request.contextPath}/frontAssets/images/logo.jpg" style="height: 40px;margin-left: 10px">
        <c:if test="${ordinaryUser!=null}">
            <%--<a data-ajax="false" href="#" class="ui-btn">${ordinaryUser.nickname}</a>--%>
            <a data-ajax="false" href="#logoutPanel" class="ui-btn" id="userNickName">${ordinaryUser.nickname}</a>

            <div data-role="panel" id="logoutPanel" data-display="overlay" data-position="right">
                <a data-ajax="false" href="${pageContext.request.contextPath}/logout" class="ui-btn ui-btn-inline ui-shadow ui-corner-all ui-btn-a">退出登录</a>
            </div>
        </c:if>
        <c:if test="${ordinaryUser==null}">
            <a data-ajax="false" href="${pageContext.request.contextPath}/login" class="ui-btn">登录</a>
        </c:if>
    </div>


    <div data-role="main" class="ui-content">

        <!--限时秒杀-->
        <div class="flash-sale">
            <c:forEach items="${shunShopList}" var="list">
                <a class="ui-grid-solo" href="${pageContext.request.contextPath}/commodityDetail?id=${list.id}&type=shunShop" data-ajax="false">
                    <div class="ui-block-a">
                        <div>
                            <div class="countdown">
                                <p>距活动结束还剩：</p>
                                <ul class="timer" data-endTime="${list.endTimeToString()}">
                                    <li> <span class="days">00</span></li>
                                    <li class="seperator">天</li>
                                    <li> <span class="hours">00</span></li>
                                    <li class="seperator">时</li>
                                    <li> <span class="minutes">00</span></li>
                                    <li class="seperator">分</li>
                                    <li> <span class="seconds">00</span></li>
                                    <li class="seperator">秒</li>
                                </ul>
                            </div>
                        </div>
                        <img src="${pageContext.request.contextPath}/${list.firstPhoto}">
                        <div class="commodity-info">
                            <div>${list.name}</div>
                            <div class="price"><span>${list.thirdCost}</span><span>${list.secondCost}</span></div>
                        </div>
                    </div>
                </a>
            </c:forEach>

        </div>
    </div>

    <!--公共底部-->
    <div data-role="footer" class="ui-footer-fixed">
        <div data-role="navbar">
            <ul>
                <li><a data-ajax="false" href="${pageContext.request.contextPath}/index" class="ui-btn" data-inline="true" data-icon="home">首页</a></li>
                <li><a data-ajax="false" href="${pageContext.request.contextPath}/flashSale" class="ui-btn" data-inline="true" data-icon="clock">限时秒杀</a></li>
                <li><a data-ajax="false" href="${pageContext.request.contextPath}/categories" class="ui-btn" data-inline="true" data-icon="bars">商品分类</a></li>
                <li><a data-ajax="false" href="${pageContext.request.contextPath}/userCenter" class="ui-btn" data-inline="true" data-icon="user">个人中心</a></li>
            </ul>
        </div>
    </div>

</div>
<script>
    var contextPath="${pageContext.request.contextPath}";
</script>

<script src="${pageContext.request.contextPath}/frontAssets/js/common/jquery.min.js" rel="script"></script>
<script src="${pageContext.request.contextPath}/frontAssets/js/common/jquery.downCount.js" rel="script"></script>
<script src="${pageContext.request.contextPath}/frontAssets/jquery.mobile/jquery.mobile-1.4.5.min.js" rel="script"></script>
<script src="${pageContext.request.contextPath}/frontAssets/js/common.js" rel="script"></script>
<script src="${pageContext.request.contextPath}/frontAssets/js/flash-sale.js" rel="script"></script>

</body>
</html>
