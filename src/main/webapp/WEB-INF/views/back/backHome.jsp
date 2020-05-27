<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:c="http://java.sun.com/jsp/jstl/core">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<link rel="stylesheet" href="/layui/css/layui.css">
<script type="text/javascript" src="/layui/layui.js"></script>
<body style="background:#393D49">
<div style="display: flex; background: #393D49">
    <jsp:include page="left.jsp"></jsp:include>
    <div style="width: 80%;">
        <jsp:include page="top.jsp"></jsp:include>
        <div style="width: 100%">
            <div style="text-align: center;background: #eaeaea;height: 500px;">
                <span style="margin-top: 40%"><h1>小瓜书店后台管理</h1></span>
            </div>
        </div>
    </div>
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
</html>