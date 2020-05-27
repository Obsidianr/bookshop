<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css">
</head>

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
                            <button id="checked-${order.oId}" class="layui-btn">确认</button>
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
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="layui/layui.js"></script>
<script>

    layui.use('layer', function(){
        var layer = layui.layer;
        $("[id^=checked-]").click(function () {
            let id = this.id.split("-")[1];
            console.log(id);
            layer.open({
                type: 1
                ,title: false //不显示标题栏
                ,closeBtn: false
                ,area: '300px;'
                ,shade: 0.8
                ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
                ,btn: ['确认发货', '取消']
                ,btnAlign: 'c'
                ,moveType: 1 //拖拽模式，0或者1
                ,content: '<div style="text-align: center;margin: 30px">选择快递\n' +
                    '      <select name="quiz2">\n' +
                    '        <option value="">请选快递</option>\n' +
                    '        <option value="SF">顺丰速运</option>\n' +
                    '        <option value="YT" >圆通快递</option>\n' +
                    '        <option value="bs">百世物流</option>\n' +
                    '        <option value="STO">申通快递</option>\n' +
                    '        <option value="ZTO">中通快递</option>\n' +
                    '      </select>\n' +
                    '    </div>'
                ,success: function(layero){
                    var btn = layero.find('.layui-layer-btn');
                    btn.find('.layui-layer-btn0').attr({
                        href: 'orderConfirm?id='+id
                        ,target: '_blank'
                    });
                }
            });
        })
        layer.msg('hello');
    });
</script>
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