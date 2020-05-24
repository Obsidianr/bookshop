<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:c="http://java.sun.com/jsp/jstl/core">
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
        <div style="background: #eaeaea;display: flex;padding-top: 10px;height: 600px;">
            <form class="layui-form" action="updateAdmin" method="post" >
                <div style="display: flex;margin-left: 20px ">
                    <div>
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">管理员编号</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="id" value="${admin.id}" class="layui-input" lay-verify="required">
                                </div>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">姓名</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="name" value="${admin.name}" class="layui-input" lay-verify="required">
                                </div>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">手机号</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="tel" value="${admin.tel}" class="layui-input" lay-verify="required|phone">
                                </div>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">密码</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="password" value="${admin.password}" class="layui-input" lay-verify="required">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="layui-form-item" style="text-align: center">
                    <div class="layui-input-block">
                        <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">确定修改</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
            ${Msg}
        </div>
    </div>
</div>

<script>
    layui.use(['form', 'layedit', 'laydate','upload'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate
            ,$ = layui.jquery

    });
</script>
</body>
</html>