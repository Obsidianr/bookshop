<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
</head>
<style>
    #loginBtn:hover {
        color: red;
        cursor: pointer;
    }
</style>
<body>
<div style="display: flex;padding-bottom: 5px;align-items: center">
    <div style="width: 25%;margin-left: 10px;display: flex">
        <a href="/">首页</a>
        <div style="display: flex;background:#86c5fa;width: 140px;margin-left: 20px">
            <img src="/imgs/logo.jpg" style="width: 40px;height: 40px">
            <span style="font-size: 140%;margin-top: 8px;color: aliceblue">小瓜书店</span>
        </div>
    </div>
    <div style="width: 50%;display: flex;border: solid blue">
        <div style="width: 80%">
            <input type="text" style="height: 30px;width: 100%">
        </div>
        <div style="color: aliceblue;background: darkblue;padding: 5px 20px;width: 20%;text-align: center">
            搜索
        </div>
    </div>
    <div onclick="window.location='shopcartPage'" style="cursor: pointer; color: darkblue;width: 20%;text-align: center;background: darkgray;border: solid lightgray 1px;padding: 5px;margin-left: 30px;margin-right: 30px">
        我的购物车(<span style="font-size: large;color: red">${sessionScope.shopCount}</span>)
    </div>
    <div id="loginBtn" onclick="window.location='loginPage'" style=" width: 50px;text-align: center;background: darkgray;border: solid lightgray 1px;padding: 5px;margin-left: 30px;margin-right: 30px">
        登录
    </div>
    <div id="userName"  style=" text-align: center;padding: 5px;margin-left: 30px;margin-right: 30px">
        登录
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="layui/layui.js"></script>
<script >
    layui.use(['layer'], function(){
        var layer = layui.layer

    })
</script>

</body>
</html>