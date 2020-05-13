<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:c="http://java.sun.com/jsp/jstl/core">
    <head>
        <meta charset="UTF-8">
        <title>登录</title>
    </head>
    <link rel="stylesheet" href="/layui/css/layui.css">
    <script type="text/javascript" src="/layui/layui.js"></script>
    <body style="background: #2E2D3C">
    <div>
        <div style="display: flex;justify-content: center;margin-top: 13%;background: #2E2D3C">
            <form  method="post" class="layui-form" action="doLogin" style="padding: 20px;border-radius: 10px;box-shadow: 0 0 10px #1E9FFF">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label" style="color: white">手机</label>
                        <div class="layui-input-inline">
                            <input type="tel" name="phone" lay-verify="phone" class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label" style="color: white">密码</label>
                        <div class="layui-input-inline">
                            <input type="password" name="password" lay-verify="required" class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div  style="text-align: center">
                        <div  >
                            <span style="color: red">${errorMsg}</span>
                        </div>
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">登录</button>
                        <a href="registerPage"> <button  class="layui-btn layui-btn-primary" >注册</button> </a>
                    </div>
                </div>
            </form>
        </div>

    </div>
    </body>
</html>