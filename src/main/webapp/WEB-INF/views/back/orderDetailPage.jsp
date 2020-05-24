<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
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
        <div style="background: #eaeaea;width: 90%;margin: 10px;height: 600px">
            <table class="layui-table" style="padding:10px">
                <thead>
                <tr>
                    <th>书籍编号</th>
                    <th>封面</th>
                    <th>书名</th>
                    <th>出版商</th>
                    <th>单价</th>
                    <th>数量</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="book" items="${bookList}" varStatus="vs" >
                    <tr>
                        <td>${book.bId}</td>
                        <td><img src="${book.img}" style="width: 100px; height: 100px"></td>
                        <td>${book.bookName}</td>
                        <td>${book.publisher}</td>
                        <td>¥${book.price}</td>
                        <td>${book.stock}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        ${Msg}
    </div>
</div>
</body>
</html>