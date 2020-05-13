<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:c="http://java.sun.com/jsp/jstl/core">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<link rel="stylesheet" href="/static/layui/css/layui.css">
<script type="text/javascript" src="/static/layui/layui.js"></script>
<body>
    <div style="width: 15%">
        <ul class="layui-nav layui-nav-tree" lay-filter="test" style="width: 100%;padding-left: 20px">
            <!-- 侧边导航: <ul class="layui-nav layui-nav-tree layui-nav-side"> -->
            <li class="layui-nav-item">
                <a href="javascript:;">图书管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="adminBookPage">管理图书</a></dd>
                    <dd><a href="addBookPage">添加图书</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">用户管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="adminUserPage">管理用户</a></dd>
                    <dd><a href="addUserPage">添加用户</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">管理员管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="adminAdministrator">管理管理员</a></dd>
                    <dd><a href="addAdminPage">添加管理员</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">订单管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="checkOrderPage">确认订单<span class="layui-badge">9</span></a></dd>
                    <dd><a href="">查询订单</a></dd>
                </dl>
            </li>
        </ul>
    </div>
<script src="//res.layui.com/layui/dist/layui.js" charset="utf-8"></script>
<script>
    layui.use('element', function(){
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

        //监听导航点击
        element.on('nav(demo)', function(elem){
            //console.log(elem)
            layer.msg(elem.text());
        });
    });
</script>
</body>
