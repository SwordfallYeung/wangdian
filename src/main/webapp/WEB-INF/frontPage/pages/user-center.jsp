<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/frontAssets/images/logo.jpg" type="image/x-icon"/>
    <link rel="stylesheet" href="http://apps.bdimg.com/libs/jquerymobile/1.4.5/jquery.mobile-1.4.5.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/frontAssets/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/frontAssets/css/user-center.css">
    <title>个人中心</title>
</head>
<body>
<div data-role="page" id="page">

    <!--公共头部-->
    <div data-role="header" class="fixed-header">
        <a href="#" class="ui-btn" style="visibility: hidden"></a>
        <img src="${pageContext.request.contextPath}/frontAssets/images/logo.jpg" style="height: 40px;margin-left: 10px">
        <a data-ajax="false" href="#logoutPanel" class="ui-btn" id="userNickName">${ordinaryUser.nickname}</a>

        <div data-role="panel" id="logoutPanel" data-display="overlay" data-position="right">
            <a data-ajax="false" href="${pageContext.request.contextPath}/logout" class="ui-btn ui-btn-inline ui-shadow ui-corner-all ui-btn-a">退出登录</a>
        </div>
    </div>


    <div data-role="main" class="ui-content">
        <a href="#nickName" data-rel="popup" class="ui-btn" data-position-to="window">修改昵称<span id="nickNameShow">${ordinaryUser.nickname}</span></a>
        <a href="#email" data-rel="popup" class="ui-btn" data-position-to="window">修改邮箱<span id="emailShow">${ordinaryUser.email}</span></a>
        <a href="#phone" data-rel="popup" class="ui-btn" data-position-to="window">修改手机号<span id="phoneShow">${ordinaryUser.telephone}</span></a>

        <div data-role="popup" id="nickName" class="ui-content" data-overlay-theme="b">
            <div data-role="header">
                <h1>修改昵称</h1>
            </div>
            <div class="ui-field-contain">
                <input type="text" name="nickname" placeholder="请输入新昵称：">
            </div>
            <div class="alertInfo"></div>
            <button class="ui-btn ui-corner-all" id="changeNickNameBtn">确认修改</button>
        </div>
        <div data-role="popup" id="email" class="ui-content" data-overlay-theme="b">
            <div data-role="header">
                <h1>修改邮箱</h1>
            </div>
            <div class="ui-field-contain">
                <input type="email" name="email" placeholder="请输入新邮箱：">
            </div>
            <div class="alertInfo"></div>
            <button class="ui-btn ui-corner-all" id="changeEmailBtn">确认修改</button>
        </div>
        <div data-role="popup" id="phone" class="ui-content" data-overlay-theme="b">
            <div data-role="header">
                <h1>修改手机号</h1>
            </div>
            <div class="ui-field-contain">
                <input type="text" name="phone" placeholder="请输入新手机号：">
            </div>
            <div class="alertInfo"></div>
            <button class="ui-btn ui-corner-all" id="changePhoneBtn">确认修改</button>
        </div>

        <a data-ajax="false" href="${pageContext.request.contextPath}/changePassword?userId=${ordinaryUser.id}" class="ui-btn">修改密码</a>
        <a data-ajax="false" href="${pageContext.request.contextPath}/addressManagement?userId=${ordinaryUser.id}" class="ui-btn">管理收货地址</a>
        <a data-ajax="false" href="${pageContext.request.contextPath}/myOrder?userId=${ordinaryUser.id}" class="ui-btn">我的订单</a>
        <a data-ajax="false" href="${pageContext.request.contextPath}/myShopCart?userId=${ordinaryUser.id}" class="ui-btn">我的购物车</a>


        <a data-ajax="false" href="${pageContext.request.contextPath}/logout" style="text-decoration: none;"><button id="logoutBtn" class="ui-btn">退出登录</button></a>
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
    var userId=${ordinaryUser.id};
</script>

<script src="${pageContext.request.contextPath}/frontAssets/js/common/jquery.min.js" rel="script"></script>
<script src="${pageContext.request.contextPath}/frontAssets/jquery.mobile/jquery.mobile-1.4.5.min.js" rel="script"></script>
<script src="${pageContext.request.contextPath}/frontAssets/js/common.js" rel="script"></script>
<script src="${pageContext.request.contextPath}/frontAssets/js/user-center.js" rel="script"></script>

</body>
</html>