<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="${pageContext.request.contextPath}/admin/profit/list" method="post">
        <div class="bjui-searchBar">
            <%--<label>商品类型：</label><input type="text" name="shopType" value="${shopType}" class="form-control" size="10" />--%>
            <%--<label>商品型号：</label><input type="text" name="shopModel" value="${shopModel}" class="form-control" size="10" />--%>
            <%--<label>商品名称：</label><input type="text" name="shopName" value="${shopName}" class="form-control" size="10" />--%>
            <%--<label>商品编号：</label><input type="text" name="shopNumber" value="${shopNumber}" class="form-control" size="10" />--%>
            <%--<div style="margin-top: 5px;">--%>
                <label>起止时间：</label><input type="text" id="startTime" name="startTime" data-toggle="datepicker" value="${startTime}" class="form-control" size="12" />
                <label>结束时间：</label><input type="text" id="endTime" name="endTime" data-toggle="datepicker" value="${endTime}" class="form-control" size="12" />
                注意：起止时间与结束同时填，才能准确搜索！！！
            <%--</div>--%>
            <button type="submit" class="btn-default" data-icon="search">查询</button>
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>


        </div>
    </form>
</div>

<div class="bjui-pageContent">
    <div class="alert alert-warning " style="font-size: 14px;margin-top: 10px;">注意：以下的收益信息都是来自已经确认收货的订单，不包括其他状态的订单！！！</div>
         <div class="pageFormContent" data-layout-h="0">
             <table class="table table-condensed table-hover" width="100%" >
                 <thead>
                 <label>订单统计信息（以个数为单位）</label>
                 </thead>
                 <tbody>
                       <tr >
                           <td colspan="2" style="width: 50%;">
                               <label class="control-label x150">已提交订单的订单数：</label>${tiJiaDingDanCount}
                           </td>
                           <td colspan="2">
                               <label class="control-label x150">已付款未发货的订单数：</label>${yiFuKuanWeiFaHuoCount}
                           </td>
                       </tr>

                       <tr>
                           <td colspan="2">
                               <label class="control-label x150">已付款已发货的订单数：</label>${yiFuKuanYiFaHuoCount}
                           </td>
                           <td colspan="2">
                               <label class="control-label x150">已确认收货的订单数：</label>${yiQueShouHuoCount}
                           </td>

                       </tr>
                       <tr>
                           <td colspan="2">
                               <label class="control-label x150">申请退款中的订单数：</label>${shenQingTuiHuoZhongCount}
                           </td>
                           <td colspan="2">
                               <label class="control-label x150">已退款的订单数：</label>${yiKuanCount}
                           </td>
                       </tr>
                 </tbody>
             </table>

             <div style="padding: 10px;"></div>

             <table id="tabledit1" class="table table-bordered table-hover table-striped table-top" width="100%">
                 <thead>
                 <label style="line-height: 28px;">收益信息（信息来自已经确认收货的订单）</label>
                 <tr>
                     <th align="center" >店主</th>
                     <th align="center" >截止目前总收益（元）</th>
                     <th align="center" >已提现（元）</th>
                     <th align="center" >未提现（元）</th>
                     <th align="center" >消息</th>
                     <th align="center" >操作</th>
                 </tr>
                 </thead>
                 <tbody>
                         <tr >
                             <td>${shopKeeper}</td>
                             <td>${allProfit}</td>
                             <td>${yiTiXian}</td>
                             <td><c:if test="${allProfit!=0}"> <fmt:formatNumber type="number" pattern="#.#" value="${allProfit-yiTiXian}"/>元</c:if><c:if test="${allProfit==0}">0元</c:if> </td>
                             <td>${message}</td>
                             <td data-noedit="true">
                                 <a href="${pageContext.request.contextPath}/admin/shopKeeper/profit/tiXian?shopKeeper=${shopKeeper}" class="btn btn-default" data-toggle="dialog" data-width="400" data-height="140" data-id="dialog-mask" data-mask="true">提现</a>
                             </td>
                         </tr>
                 </tbody>
             </table>
             <c:if test="${errorMessage!=null&&!errorMessage.equals('')}">
                 <div class="alert alert-warning " style="font-size: 14px;margin-top: 16px;margin-bottom: 0px;">${errorMessage}</div>
             </c:if>
         </div>

</div>

<script>

</script>

