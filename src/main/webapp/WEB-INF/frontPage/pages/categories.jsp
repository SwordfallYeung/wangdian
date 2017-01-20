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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/frontAssets/css/categories.css">
    <title>商品分类</title>
</head>
<body>
<div data-role="page">


    <!--公共头部-->
    <div data-role="header" class="fixed-header">
        <a href="#" class="ui-btn" style="visibility: hidden"></a>
        <img src="${pageContext.request.contextPath}/frontAssets/images/logo.jpg" style="height: 40px;margin-left: 10px;float: left">
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
        <div class="search-box">
            <form data-ajax="false" method="post" action="${pageContext.request.contextPath}/search">
                <form data-ajax="false" method="post" action="${pageContext.request.contextPath}/search">
                    <button class="ui-btn ui-shadow ui-corner-all ui-icon-search ui-btn-icon-notext ui-nodisc-icon" id="searchBtn">搜索</button>
                    <input type="text" name="shopName" placeholder="搜索商品">
                </form>
            </form>
        </div>
    </div>


    <div data-role="main" class="ui-content">
        <!--商品分类-->

        <div class="my-slider">
            <ul id="sliderList">

            </ul>
        </div>


        <!--商品推荐-->
        <div class="recommendation">
            <div class="title">商品推荐</div>
            <div class="commodities">
                <c:forEach items="${shopList}" var="list">
                    <a data-ajax="false" class="ui-grid-solo" href="${pageContext.request.contextPath}/commodityDetail?id=${list.id}&type=shop">
                        <div class="ui-block-a">
                            <img src="${pageContext.request.contextPath}/${list.firstPhoto}">
                            <div class="commodity-info">
                                <div>${list.name}</div>
                                <div class="price"><span>${list.secondCost}</span></div>
                            </div>
                        </div>
                    </a>
                </c:forEach>
            </div>
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
    var styleNum=[];

    <c:forEach items="${shopListAll}" var="list" varStatus="i">

            styleNum["${i.index}"]="${list}";

    </c:forEach>



</script>


<script src="${pageContext.request.contextPath}/frontAssets/js/common/jquery.min.js" rel="script"></script>
<script src="${pageContext.request.contextPath}/frontAssets/js/common/jquery.event.move.js" rel="script"></script>
<script src="${pageContext.request.contextPath}/frontAssets/js/common/jquery.event.swipe.js" rel="script"></script>
<script src="${pageContext.request.contextPath}/frontAssets/unslider/js/unslider-min.js" rel="script"></script>
<script src="${pageContext.request.contextPath}/frontAssets/jquery.mobile/jquery.mobile-1.4.5.min.js" rel="script"></script>
<script src="${pageContext.request.contextPath}/frontAssets/js/common.js" rel="script"></script>
<script src="${pageContext.request.contextPath}/frontAssets/js/categories.js" rel="script"></script>

</body>
</html>