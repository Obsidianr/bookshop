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
    <div>
        <jsp:include page="top.jsp"></jsp:include>
        <div style="background: #eaeaea;display: flex;padding-top: 10px">
            <form class="layui-form" action="addBook" >
                
            </form>
            ${errorMsg}
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
            ,upload = layui.upload;
    });
</script>
</body>
</html>