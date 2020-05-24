<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<link rel="stylesheet" href="/layui/css/layui.css">
<script type="text/javascript" src="/layui/layui.js"></script>
<body style="background:#393D49">

<div style="display: flex">
    <jsp:include page="left.jsp"></jsp:include>
    <div style="width: 80%;">
        <jsp:include page="top.jsp"></jsp:include>
        <div style="background: #eaeaea;width: 90%;margin: 10px;height: 600px">
            <table class="layui-table" style="padding:10px">
                <thead>
                <tr>
                    <th>订单编号</th>
                    <th>下单用户编号</th>
                    <th>收货人</th>
                    <th>电话</th>
                    <th>地址</th>
                    <th>总金额</th>
                    <th>提交时间</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="order" items="${olist}" varStatus="vs" >
                    <tr>
                        <td>${order.oId}</td>
                        <td>${order.uId}</td>
                        <td>${order.consignee}</td>
                        <td>${order.consigneeTel}</td>
                        <td>${order.consigneeAdress}</td>
                        <td>¥${order.payment}</td>
                        <td>${order.createTime}</td>
                        <td>
                            <button  class="layui-btn" onclick="orderConfirm(${order.oId})">确认</button>
                            <button  class="layui-btn" onclick="orderDetail(${order.oId})">详情</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        ${Msg}
    </div>
</div>
<script src="//res.layui.com/layui/dist/layui.js" charset="utf-8"></script>
<script language="javascript">
    function orderConfirm(id) {
            location.href = "orderConfirm?id="+id;
    }
    function orderDetail(id) {
        location.href = "orderDetailPage?id="+id;
    }
</script>
</body>
</html>