<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<style>
    #shopItem>div{
        padding: 10px 20px;
    }
</style>
<link rel="stylesheet" href="/layui/css/layui.css">
<script type="text/javascript" src="/layui/layui.js"></script>
<body class="layui-col-xs6 layui-col-md8 layui-col-md-offset2">
<jsp:include page="frontTop.jsp"></jsp:include>
<div class="layui-row">
    <div class="layui-col-xs6 layui-col-md10 layui-col-md-offset2 " >
       <div><h2>全部商品${shopCount}</h2></div>
        <div>
            <table class="layui-table" lay-skin="line">
                <colgroup>
                </colgroup>
                <thead>
                <tr>
                    <th></th>
                    <th>封面</th>
                    <th>书名</th>
                    <th>作者</th>
                    <th>出版社</th>
                    <th>价格</th>
                    <th>数量</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="book" items="${shoppingList}">

                    <tr>
                        <td> <input type="checkbox"></td>
                        <td><img src="${book.img}" style="width: 100px; height: 100px"></td>
                        <td>${book.bookName}</td>
                        <td>${book.author}</td>
                        <td>${book.publisher}</td>
                        <td>¥${book.price}</td>
                        <td><input value="${book.count}" style="width: 30px"></td>
                        <td> <button type="button" class="layui-btn layui-btn-danger layui-btn-xs" onclick="del(${book.carId})">删除</button></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        ${Msg}
    </div>
</div>
<script>
    function del(id) {//利用对话框返回的值 （true 或者 false）
        if (confirm("确定删除")) {//如果是true ，那么就把页面转向https://blog.csdn.net/h2503652646
            location.href = "delshopItem?id="+id;
        } else {
            alert("取消删除");
        }
    }
</script>
</body>
</html>