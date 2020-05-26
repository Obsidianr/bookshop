<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html  xmlns:c="http://java.sun.com/jsp/jstl/core">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<link rel="stylesheet" href="/layui/css/layui.css">
<script type="text/javascript" src="/layui/layui.js"></script>
<body >
<div class="layui-tab">
    <h2>我的订单</h2>
    <ul class="layui-tab-title">
        <li class="layui-this">未付款</li>
        <li>待确认</li>
        <li>已完成</li>

    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">内容1</div>
        <div class="layui-tab-item">内容2</div>
        <div class="layui-tab-item">内容3</div>
    </div>
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