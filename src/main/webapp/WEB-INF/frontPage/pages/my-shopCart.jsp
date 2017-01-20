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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/frontAssets/css/my-shopCart.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/frontAssets/css/form-validate.css">
    <title>我的购物车</title>
</head>
<body>
<div data-role="page">

    <!--公共头部-->
    <div data-role="header" class="fixed-header">
        <a data-ajax="false" href="${pageContext.request.contextPath}/userCenter" class="ui-btn">返回</a>
        <h1>我的购物车</h1>
    </div>
    <!--出错信息提示-->
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

        <c:if test="${shopCartsList.size()==0}">
            <div class="not-found">
                <img src="${pageContext.request.contextPath}/frontAssets/images/shopcart-empty.png" style="width: 100%">
            </div>
        </c:if>
        <c:if test="${shopCartsList.size()>0}">
            <div class="my-shopCart">

            </div>
            <form method="post" action="${pageContext.request.contextPath}/myShopCartToSubmitOrder" data-ajax="false">
                <%
                    int showNum=0;
                %>
                <c:forEach items="${shopCartsList}" var="shopCart" varStatus="i">
                       <%--${shopCart.detail.equals()}--%>
                       <c:if test="${shopCart.isDel==0}">
                           <%
                               showNum++;
                           %>
                           <fieldset data-role="controlgroup">
                               <label for="shopCartIdList${i.index}">
                                   <div class="shop-cart">
                                       <img src="${pageContext.request.contextPath}/${shopCart.photo}">
                                       <div>
                                           <div>${shopCart.shopName}</div>
                                           <div>${shopCart.detail}</div>
                                           <div>商品单价：￥${shopCart.secondCost}</div>
                                           <div>数量：${shopCart.count}</div>
                                       </div>
                                   </div>
                               </label>
                               <input type="checkbox" name="shopCartIdList" id="shopCartIdList${i.index}" value="${shopCart.id}">
                           </fieldset>
                       </c:if>
                </c:forEach>
                <%
                    if(showNum==0){
                        %>
                <div class="not-found">
                    <img src="${pageContext.request.contextPath}/frontAssets/images/shopcart-empty.png" style="width: 100%">
                </div>
                <%
                    }
                %>
                <div class="options">
                    <button type="button" class="ui-btn unavailable" data-inline="true" value="删除" id="delBtn" >删除</button>
                    <button type="submit" class="ui-btn unavailable" data-inline="true" value="结算" id="submitBtn">结算</button>
                </div>
            </form>
        </c:if>


    </div>

</div>
<script>console.log("${shopCartsList[0]}");
    var contextPath="${pageContext.request.contextPath}";
</script>

<script src="${pageContext.request.contextPath}/frontAssets/js/common/jquery.min.js" rel="script"></script>
<script src="${pageContext.request.contextPath}/frontAssets/jquery.mobile/jquery.mobile-1.4.5.min.js" rel="script"></script>
<script src="${pageContext.request.contextPath}/frontAssets/js/my-shopCart.js" rel="script"></script>

</body>
</html>