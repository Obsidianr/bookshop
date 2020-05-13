<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:c="http://java.sun.com/jsp/jstl/core">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<link rel="stylesheet" href="/static/layui/css/layui.css">
<script type="text/javascript" src="/static/layui/layui.js"></script>
<body>
    </div>
    <div style="width: 100%">
        <div style="text-align: right">
            <ul class="layui-nav">

                <li class="layui-nav-item">
                    <a href=""><img src="//t.cn/RCzsdCq" class="layui-nav-img">我</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">修改信息</a></dd>
                        <dd><a href="javascript:;">退出</a></dd>
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
