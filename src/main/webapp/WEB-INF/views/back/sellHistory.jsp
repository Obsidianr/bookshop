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
            <div style="display: flex" >
                <div style="margin: 10px;border: solid lightgray 1px;box-shadow: 0 0 4px lightgray;">
                    <img src="${book.img}" style="width: 200px;height: 200px">
                </div>
                <div >
                    <div style="margin-top: 30px;margin-left: 10px;margin-bottom: 10px" >
                        <div style="margin: 10px"><h1>${book.bookName}</h1></div>
                        <div style="background: #eaeaea;padding: 5px">
                            <div style="margin: 10px" style="display: flex"><span style="font-size: larger;color: #9F9F9F">作者: ${book.author}</span></div>
                            <div style="margin: 10px" style="display: flex"><span style="font-size: larger;color: #9F9F9F">出版社: ${book.publisher}</span></div>
                            <div style="margin: 10px" style="display: flex"><span style="font-size: larger;color: #9F9F9F">库存: ${book.stock}</span></div>
                            <div style="margin: 10px" style="display: flex">
                                <span style="font-size: larger;color: #616161">价格: </span>
                                <span style="color: orangered;font-size:xx-large">¥${book.price}</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div style="background: #eaeaea;height: 600px;margin: 10px">
                <table class="layui-table">
                    <colgroup>
                        <col>
                    </colgroup>
                    <thead>
                    <tr>
                        <th>订单编号</th>
                        <th>出售数量</th>
                        <th>出售单价</th>
                        <th>出售时间</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="hr" items="${historyRecords}" varStatus="vs" >
                        <tr>
                            <td>${hr.oId}</td>
                            <td>${hr.count}</td>
                            <td>${hr.originPrice}</td>
                            <td>${hr.finishTime}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </div>
        </div>
        ${Msg}
    </div>
</div>
</body>
</html>