<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="${pageContext.request.contextPath}/admin/profit/list" method="post">
        <div class="bjui-searchBar">
            <%--<label>商品类型：</label><input type="text" name="shopType" value="${shopType}" class="form-control" size="10" />--%>
            <%--<label>商品型号：</label><input type="text" name="shopModel" value="${shopModel}" class="form-control" size="10" />--%>
            <%--<label>商品名称：</label><input type="text" name="shopName" value="${shopName}" class="form-control" size="10" />--%>
            <%--<label>商品编号：</label><input type="text" name="shopNumber" value="${shopNumber}" class="form-control" size="10" />--%>
                <%--<div style="margin-top: 5px;">--%>
                    <label>店主：</label><input type="text" name="shopKeeper" value="${shopKeeper}" class="form-control" size="10" />
                    <label>起止时间：</label><input type="text" id="startTime" name="startTime" data-toggle="datepicker" value="${startTime}" class="form-control" size="12" />
                    <label>结束时间：</label><input type="text" id="endTime" name="endTime" data-toggle="datepicker" value="${endTime}" class="form-control" size="12" />
                    注意：起止时间与结束同时填，才能准确搜索！！！
                <%--</div>--%>
                <button type="submit" class="btn-default" data-icon="search">查询</button>
               <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            <%--<br>--%>


        </div>
    </form>
</div>

<div class="bjui-pageContent">
    <div class="alert alert-warning " style="font-size: 14px;margin-top: 10px;">注意：以下的商品信息都是来自已经确认收货的订单，不包括其他状态的订单！！！</div>
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

             <%--<table class="table table-condensed table-hover" width="100%" >--%>
                 <%--<thead>--%>
                 <%--<label>商品信息（以件数，或位数为单位）（信息来自已经确认收货的订单）</label>--%>
                 <%--</thead>--%>
                 <%--<tbody>--%>
                 <%--<tr >--%>
                     <%--<td colspan="2" style="width: 50%;">--%>
                         <%--<label class="control-label x150">涉及的商品类型：</label>${shopTypeCount}--%>
                         <%--&lt;%&ndash;<input type="text" data-rule="required" name="shopNumber" value="${orders.shopNumber}" size="20">&ndash;%&gt;--%>
                     <%--</td>--%>
                     <%--<td colspan="2" >--%>
                         <%--<label class="control-label x150">涉及的商品型号：</label>--%>
                         <%--&lt;%&ndash;<input type="text" data-rule="required" name="shopName" value="${orders.shopName}" size="20">&ndash;%&gt;--%>
                     <%--</td>--%>
                 <%--</tr>--%>
                 <%--<tr >--%>
                     <%--<td colspan="2" style="width: 50%;">--%>
                         <%--<label class="control-label x150">涉及的商品：</label>--%>
                         <%--&lt;%&ndash;<input type="text" data-rule="required" name="shopType" value="${orders.shopType}" size="20">&ndash;%&gt;--%>
                     <%--</td>--%>
                     <%--<td colspan="2" style="width: 50%;">--%>
                         <%--<label class="control-label x150">涉及的店主：</label>--%>
                         <%--&lt;%&ndash;<input type="text" data-rule="required" name="shopType" value="${orders.shopType}" size="20">&ndash;%&gt;--%>
                     <%--</td>--%>
                 <%--</tr>--%>

                 <%--</tbody>--%>
             <%--</table>--%>

             <%--<div style="padding: 10px;"></div>--%>

             <%--<table class="table table-condensed table-hover" width="100%" >--%>
                 <%--<thead>--%>
                 <%--<label>其他信息</label>--%>
                 <%--</thead>--%>
                 <%--<tbody>--%>
                 <%--<tr >--%>
                     <%--<td colspan="2" style="width: 50%;">--%>
                         <%--<label class="control-label x100">成本价：</label>--%>
                         <%--<input type="text" data-rule="required" name="firstCost" value="${orders.firstCost}" size="20">--%>
                     <%--</td>--%>
                     <%--<td colspan="2" >--%>
                         <%--<label class="control-label x100">销售价：</label>--%>
                         <%--<input type="text" data-rule="required" name="secondCost" value="${orders.secondCost}" size="20">--%>
                     <%--</td>--%>
                 <%--</tr>--%>
                 <%--<tr >--%>
                     <%--<td colspan="2" style="width: 50%;">--%>
                         <%--<label class="control-label x100">利润：</label>--%>
                         <%--<input type="text" data-rule="required" name="profits" &lt;%&ndash;value="${orders.profits}"&ndash;%&gt; value="${orders.secondCost-orders.firstCost}" size="20">--%>
                     <%--</td>--%>
                     <%--<td colspan="2">--%>
                         <%--<label class="control-label x100">店主：</label>--%>
                         <%--<input type="text" data-rule="required" name="shopKeeper" value="${orders.shopKeeper}" size="20">--%>
                     <%--</td>--%>
                 <%--</tr>--%>

                 <%--</tbody>--%>
             <%--</table>--%>

         </div>

</div>

<script>

</script>

