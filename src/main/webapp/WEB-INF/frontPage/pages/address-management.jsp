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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/frontAssets/css/address-management.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/frontAssets/css/form-validate.css">
    <title>管理收货地址</title>
</head>
<body>
<div data-role="page">

    <!--公共头部-->
    <div data-role="header" class="fixed-header">
        <a data-ajax="false" href="${pageContext.request.contextPath}/userCenter" class="ui-btn">返回</a>
        <h1>管理收货地址</h1>
    </div>

    <a href="#alertInfo" data-rel="popup" class="ui-btn" id="alertInfoBtn" data-position-to="window"></a>
    <div data-role="popup" id="alertInfo" class="ui-content" data-overlay-theme="b">
        <div data-role="header">
            <h1>提示信息</h1>
        </div>
        <div class="ui-field-contain">
            <div class="alert-info"></div>
        </div>
        <div class="ui-grid-a">
            <div class="ui-block-a"><a href="#" class="ui-btn ui-corner-all ui-mini" data-rel="back">取消</a></div>
            <div class="ui-block-b"><a href="#" class="ui-btn ui-corner-all ui-mini confirmBtn" data-rel="back" style="background-color: #FF463C;color: #fff">确定</a></div>
        </div>
    </div>

    <div data-role="main" class="ui-content">
        <a data-ajax="false" href="${pageContext.request.contextPath}/addAddress?userId=${userId}" class="ui-btn" id="addAddressBtn">新增收货地址</a>

        <c:if test="${userAddressList.size()==0}">
            <div class="prompt-info"><img src="${pageContext.request.contextPath}/frontAssets/images/no-address.png" style="width: 100%"></div>
        </c:if>
        <c:if test="${userAddressList.size()!=0}">
            <c:forEach items="${userAddressList}" var="list">
                <div class="address">
                    <div class="address-info">
                        <div class="name-phone"><span>${list.name}</span><span>${list.phone}</span></div>
                        <p>${list.province}${list.city}${list.area}${list.town}<br>${list.adddetail}</p>
                    </div>
                    <div class="address-options ui-grid-b">
                        <div class="ui-block-a"></div>
                        <div class="ui-block-b"><a href="${pageContext.request.contextPath}/addAddressEdit?id=${list.id}" class="ui-btn" data-ajax="false">编辑</a></div>
                        <div class="ui-block-c"><a href="${pageContext.request.contextPath}/addAddressDelete?id=${list.id}" class="ui-btn delBtn" data-ajax="false">删除</a></div>
                    </div>
                </div>
            </c:forEach>
        </c:if>

        <%--<div class="address">
            <div class="address-info">
                <div class="name-phone"><span>张三</span><span>13012341234</span></div>
                <p>湖北省武汉市洪山区珞南街道<br>湖北省武汉理工大学升升学生公寓</p>
            </div>
            <div class="address-options ui-grid-b">
                <div class="ui-block-b"><a href="#" class="ui-btn"></a></div>
                <div class="ui-block-b"><a href="#" class="ui-btn">编辑</a></div>
                <div class="ui-block-c"><a href="http://www.baidu.com" class="ui-btn delBtn">删除</a></div>
            </div>
        </div>--%>
    </div>

    <!--公共底部-->

</div>


<script src="${pageContext.request.contextPath}/frontAssets/js/common/jquery.min.js" rel="script"></script>
<script src="${pageContext.request.contextPath}/frontAssets/jquery.mobile/jquery.mobile-1.4.5.min.js" rel="script"></script>
<script src="${pageContext.request.contextPath}/frontAssets/js/address-management.js" rel="script"></script>

</body>
</html>