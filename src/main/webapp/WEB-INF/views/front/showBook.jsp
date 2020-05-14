<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:c="http://java.sun.com/jsp/jstl/core">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<link rel="stylesheet" href="/layui/css/layui.css">
<script type="text/javascript" src="/layui/layui.js"></script>
<body >
<div style="display: flex">
    <c:forEach var="book" items="${bookList}">
        <div style=" width: 25%; padding: 10px;border: solid lightgray 1px;box-shadow: 0 0 4px lightgray;margin: 5px ">
            <div style="text-align: center"><img src="/imgs/${book.img}"></div>
            <div style="padding: 2px;cursor: pointer">${book.bookName}</div>
            <div style="padding: 2px;color: lightgray;font-size: 12px">${book.publisher}</div>
            <div style="color: orangered">¥<span style="font-size: 20px">${book.price}</span></div>
        </div>
    </c:forEach>
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