<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<style>
    .booklist>div{
        padding: 10px;
    }
</style>
<link rel="stylesheet" href="/layui/css/layui.css">
<script type="text/javascript" src="/layui/layui.js"></script>
<body >
<jsp:include page="frontTop.jsp" flush="true"></jsp:include>
<div class="layui-row" style="margin-top: 20px">
    <div class="layui-col-xs6 layui-col-md10 layui-col-md-offset2 " >
        <div style="width: 80%;background: #bfbfbf;padding: 10px">
            <div style="background: #e4e4e4;margin: 10px;" >
                <form method="post" action="generateOrder" id="orderForm">
                    <div style="display: flex;margin: 10px;padding: 5px">

                        昵称：<input id="rname" style="font-size: large;" name="name" value="${userInfo.name}">
                        电话：<input id="rtel"  style="font-size: large;" name="tel" value="${userInfo.tel}">
                    </div>
                    <div style="background: #e4e4e4;margin: 10px;padding: 5px">
                        地址：<input id="raddress"  style="font-size: large;" name="adress" value="${userInfo.adress}">
                    </div>
                    <input  name="cost" value="${sum}" hidden>
                </form>


            </div>
            <div style="background: #e4e4e4;margin: 10px;padding-bottom: 10px">
                <c:forEach var="book" items="${sessionScope.billList}">
                    <div style="display: flex;border: solid lightgray 1px;" class="booklist">
                        <div><img src="${book.img}" style="width: 100px; height: 100px"></div>
                        <div>
                            <div style="font-size: large;"> ${book.bookName}</div>
                            <div style="font-size: large;color: red;margin-top: 20px"> ¥${book.price} × ${book.count}</div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div style="text-align: center;background:#e4e4e4">
                总计：<span style="font-size: x-large;color: red;padding: 10px;margin: 10px">¥${sum}</span>
            </div>


            <div > <button class="layui-btn layui-btn-danger" id="submit" style="background: red;width: 100%">提交订单</button></div>
        </div>
    </div>
</div>


<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="layui/layui.js"></script>
<script >
    layui.use(['layer'], function(){
        var layer = layui.layer
        $("#submit").click( function () {
            $("#orderForm").submit();
        })
    })
</script>
</body>
</html>