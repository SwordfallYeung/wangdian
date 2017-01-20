<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/frontAssets/images/logo.jpg" type="image/x-icon"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/frontAssets/jquery.mobile/jquery.mobile-1.4.5.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/frontAssets/unslider/css/unslider.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/frontAssets/unslider/css/unslider-dots.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/frontAssets/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/frontAssets/css/commodity-detail.css">
    <title>商品详情</title>
</head>
<body>
<div data-role="page">

    <!--公共头部-->
    <div data-role="header" class="fixed-header">
        <c:if test="${type.equals('shunShop')}">
            <a href="${pageContext.request.contextPath}/flashSale" class="ui-btn" data-ajax="false">返回</a>
        </c:if>
        <c:if test="${type.equals('shop')}">
            <a href="${pageContext.request.contextPath}/categories" class="ui-btn" data-ajax="false">返回</a>
        </c:if>
        <h1>商品详情</h1>
    </div>


    <div data-role="main" class="ui-content">

        <%--显示提示信息--%>
        <%
            if(session.getAttribute("promptInfo")!=null){
        %>
            <div class="prompt-info"><span><% out.println(session.getAttribute("promptInfo")); %></span></div>
        <%
                session.removeAttribute("promptInfo");
            }
        %>

        <!--商品轮播图-->
        <div class="my-slider">
            <ul>
                <c:forEach items="${shopShowsList}" var="list">
                    <li><a ><img src="${pageContext.request.contextPath}/${list.urlPath}"></a></li>
                </c:forEach>
            </ul>
        </div>

        <c:if test="${type.equals('shop')}">
            <%--<a data-ajax="false" href="${pageContext.request.contextPath}/addToShopCartOrSubmitOrder?shopId=${shop.id}&type=shop&direction=submitOrder" class="ui-btn" id="buyBtn">立即购买</a>--%>
            <div class="user-options">
                <a data-ajax="false" href="${pageContext.request.contextPath}/chooseParam?shopId=${shop.id}&type=shop&direction=addToShopCart" class="ui-btn"  id="cartBtn" >加入购物车</a>
                <a data-ajax="false" href="${pageContext.request.contextPath}/chooseParam?shopId=${shop.id}&type=shop&direction=submitOrder" class="ui-btn"  id="buyBtn" >立即购买</a>
            </div>
        </c:if>
        <c:if test="${type.equals('shunShop')}">
            <%--<a data-ajax="false" href="${pageContext.request.contextPath}/addToShopCartOrSubmitOrder?shopId=${shop.id}&type=shunShop&direction=submitOrder" class="ui-btn" id="buyBtn">立即购买</a>--%>
            <div class="user-options">
                <a data-ajax="false" href="${pageContext.request.contextPath}/chooseParam?shopId=${shop.id}&type=shunShop&direction=addToShopCart" class="ui-btn" id="cartBtn" >加入购物车</a>
                <a data-ajax="false" href="${pageContext.request.contextPath}/chooseParam?shopId=${shop.id}&type=shunShop&direction=submitOrder" class="ui-btn" id="buyBtn" >立即购买</a>
            </div>


            <div class="countdown">
                <p>距活动结束还剩：</p>
                <ul class="timer" data-endTime="${shop.endTimeToString()}">
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
        </c:if>

        <div class="commodity-info">
            <div>
                <h4>${shop.name}</h4>
                <div class="price"><c:if test="${type.equals('shop')}">${shop.secondCost}</c:if><c:if test="${type.equals('shunShop')}">${shop.thirdCost}</c:if> </div>
            </div>
            <p class="postage">运费：￥${yunFei.yunFei}<span>（满${yunFei.mianYunFei}元免运费）</span></p>
            <p>${shop.shopDescribe}</p>
        </div>

        <!--图文详情-->
        <div class="pic-detail">
            <div class="title">图文详情</div>
            <c:forEach items="${shopPhotosList}" var="list">
                <img src="${pageContext.request.contextPath}/${list.urlPath}">
            </c:forEach>
        </div>

    </div>
</div>



    <script src="${pageContext.request.contextPath}/frontAssets/js/common/jquery.min.js" rel="script"></script>
    <script src="${pageContext.request.contextPath}/frontAssets/js/common/jquery.event.move.js" rel="script"></script>
    <script src="${pageContext.request.contextPath}/frontAssets/js/common/jquery.event.swipe.js" rel="script"></script>
    <script src="${pageContext.request.contextPath}/frontAssets/js/common/jquery.downCount.js" rel="script"></script>
    <script src="${pageContext.request.contextPath}/frontAssets/unslider/js/unslider-min.js" rel="script"></script>
    <script src="${pageContext.request.contextPath}/frontAssets/jquery.mobile/jquery.mobile-1.4.5.min.js" rel="script"></script>
    <script src="${pageContext.request.contextPath}/frontAssets/js/commodity-detail.js" rel="script"></script>

</body>
</html>