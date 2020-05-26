<%@ taglib prefix="mytag" uri="/WEB-INF/tld/Mytags.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<link rel="stylesheet" href="/layui/css/layui.css">
<script type="text/javascript" src="/layui/layui.js"></script>
<body >
<jsp:include page="frontTop.jsp" flush="true"></jsp:include>
<div class="layui-row">
    <div class="layui-col-xs12 layui-col-md4 layui-col-md-offset2">
        <div class="layui-tab" style="width: 100%">
            <ul class="layui-tab-title">
                <li class="layui-this">待付款</li>
                <li>待审批</li>
                <li>已完成</li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">
                    <c:forEach var="order" items="${unPayorders}">
                        <div style="border: solid lightgray 1px; background: #E6E6E6; margin: 10px 10px;padding: 10px">
                            <div>
                                <span>${order.consignee} &nbsp; ${order.consigneeTel}</span><br>
                                <span style="color: #9F9F9F;font-size: smaller">地址：${order.consigneeAdress}</span>
                            </div>
                            <mytag:orderItem books="${order.books}"/>
                            <span style="text-align: right;margin-right: 10px;font-size: large;float: right">总计：<span style="color: red">¥${order.payment}</span></span>
                            <div style="display: flex;padding: 10px">
                                <span style="color: #9F9F9F;font-size: smaller">创建时间${order.createTime}</span><br>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="layui-tab-item">
                    <c:forEach var="order" items="${unConfirmorders}">
                        <div style="border: solid lightgray 1px;background: #E6E6E6;margin: 10px 1px;padding: 10px">
                            <div style="padding: 10px">
                                <span>${order.consignee} &nbsp; ${order.consigneeTel}</span><br>
                                <span style="color: #9F9F9F;font-size: smaller">地址：${order.consigneeAdress}</span>
                            </div>
                            <mytag:orderItem books="${order.books}"/>
                            <span style="text-align: right;margin-right: 10px;font-size: large;float: right">总计：<span style="color: red">¥${order.payment}</span></span>
                            <div style="display: flex;padding: 10px">
                                <span style="color: #9F9F9F;font-size: smaller">创建时间${order.createTime}</span><br>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="layui-tab-item">
                    <c:forEach var="order" items="${finishedorders}">
                        <div style="border: #9F9F9F;background: #E6E6E6;margin: 10px 1px;padding: 10px">
                            <div>
                                <span>${order.consignee} &nbsp; ${order.consigneeTel}</span><br>
                                <span style="color: #9F9F9F;font-size: smaller">地址：${order.consigneeAdress}</span>
                            </div>
                            <mytag:orderItem books="${order.books}"/>
                            <span style="text-align: right;margin-right: 10px;font-size: large;float: right">总计：<span style="color: red">¥${order.payment}</span></span>
                            <div style="display: flex;padding: 10px">
                                <span style="color: #9F9F9F;font-size: smaller">创建时间${order.createTime}</span><br>
                                <span style="text-align: right;padding-right: 10px;color: #9F9F9F;font-size: smaller">完成时间${order.finishTime}</span>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
    ${Msg}
</div>
<script>
    //注意：选项卡 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function(){
        var element = layui.element;

        //…
    });
</script>

</body>
</html>