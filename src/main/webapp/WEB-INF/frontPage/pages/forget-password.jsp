<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/frontAssets/images/logo.jpg" type="image/x-icon"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/frontAssets/jquery.mobile/jquery.mobile-1.4.5.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/frontAssets/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/frontAssets/css/login.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/frontAssets/css/form-validate.css">
    <title>忘记密码</title>
</head>
<body>
<div data-role="page">

    <!--公共头部-->
    <div data-role="header" class="fixed-header">
        <a href="${pageContext.request.contextPath}/login" class="ui-btn" data-ajax="false">返回</a>
        <h1>忘记密码</h1>
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
        <a href="#" class="ui-btn ui-corner-all ui-mini" data-rel="back">确定</a>
    </div>

    <div data-role="main" class="ui-content">
        <form method="post" action="${pageContext.request.contextPath}/forgetPassword" data-ajax="false" id="forgetPwdForm">
            <div class="ui-field-contain">
                <input type="email" name="email" id="email" placeholder="请输入已绑定邮箱：">
            </div>
            <input type="submit" value="发送邮件重置密码">
        </form>
    </div>

    <!--公共底部-->

</div>

<script>
    var contextPath="${pageContext.request.contextPath}";
</script>


<script src="${pageContext.request.contextPath}/frontAssets/js/common/jquery.min.js" rel="script"></script>
<script src="${pageContext.request.contextPath}/frontAssets/jquery.mobile/jquery.mobile-1.4.5.min.js" rel="script"></script>
<script src="${pageContext.request.contextPath}/frontAssets/js/forget-password.js" rel="script"></script>

</body>
</html>