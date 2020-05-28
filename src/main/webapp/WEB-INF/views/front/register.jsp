<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:c="http://java.sun.com/jsp/jstl/core">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
</head>
<link rel="stylesheet" href="/layui/css/layui.css">
<script type="text/javascript" src="/layui/layui.js"></script>
<body>
<div>
    <div style="display: flex;justify-content: center;margin-top: 5%">
        <form  method="post" class="layui-form" action="register" style="padding: 20px;border-radius: 10px;box-shadow: 0 0 10px #1E9FFF">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">昵称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="username" lay-verify="required" class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">性别</label>
                    <div class="layui-input-inline">
                        <input type="text" name="gende" class="layui-input" lay-verify="required">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">手机</label>
                    <div class="layui-input-inline">
                        <input type="tel" name="phone" lay-verify="phone" class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-inline">
                        <input type="password" name="password" lay-verify="required" class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">地址</label>
                    <div class="layui-input-inline">
                        <input type="text" name="address" lay-verify="required" class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div  style="text-align: center">
                    <div  >
                        <span style="color: red">${Msg}</span>
                    </div>
                </div>
            </div>

            <div class="layui-form-item" align="left">
                <div class="layui-input-block">
                    <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1" style="margin-right: 15px">注册</button>

                </div>
            </div>
        </form>
    </div>

</div>
<script>
    layui.use(['form', 'layedit', 'laydate'], function() {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
    })
</script>
</body>
</html>