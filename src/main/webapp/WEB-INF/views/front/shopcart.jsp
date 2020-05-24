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
<body >
<jsp:include page="frontTop.jsp" flush="true"></jsp:include>
<div class="layui-row">
    <div class="layui-col-xs6 layui-col-md10 layui-col-md-offset2 " >
       <div><h2>全部商品${sessionScope.shopCount}</h2></div>
        <div style="width: 80%">
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
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="book" items="${shoppingList}">

                    <tr>
                        <td> <input type="checkbox" id="check-${book.carId}"></td>
                        <td><img src="${book.img}" style="width: 100px; height: 100px"></td>
                        <td>${book.bookName}</td>
                        <td>${book.author}</td>
                        <td>${book.publisher}</td>
                        <td><div> ¥<input id="price-${book.carId}" readonly="readonly" style="border: 0;outline: 0;background-color: rgba(0, 0, 0, 0);width: 20px" value="${book.price}"></div></td>
                        <td><input value="${book.count}" id="count-${book.carId}" style="width: 30px"></td>
                        <td> <button type="button" class="layui-btn layui-btn-danger layui-btn-xs" onclick="del(${book.carId})">删除</button></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        ${Msg}
    </div>
</div>
<form method="post" action="doBill" id="cartForm">
    <input id="cartInfo" name="cartInfo" hidden="hidden">
</form>
<div style="position: fixed;height: 60px;width: 100%;box-shadow: 0 0 10px lightgrey; bottom: 2px">
    <div class="layui-row">
        <div class="layui-col-xs6 layui-col-md10 layui-col-md-offset2 " >
            <div style="display: flex;text-align: right;float: right;margin-right: 20%">
                <div style="margin: 10px;color: gray">已选商品<input id="checkedCount" style="color: red;border: 0;outline: 0;background-color: rgba(0, 0, 0, 0);width: 10px" value="0">件</div>
                <div style="margin: 10px;color: gray">
                    总计: <span style="color: red;font-size: x-large">¥</span>
                    <input id="allCost"  style="font-size: x-large;color: red;border: 0;outline: 0;background-color: rgba(0, 0, 0, 0);width: 70px" value="0.0"></div>
                <div > <button class="layui-btn layui-btn-danger" id="bill" style="background: red">结算</button></div>
            </div>

        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="layui/layui.js"></script>
<script >
    layui.use(['layer'], function(){
        var layer = layui.layer
        $("[id^=check-]").click(function () {
            let sumCost = 0.0;
            let checkCount = 0;

            $("[id^=check-]").each(function () {
                if(this.checked){
                    let shopCartId = this.id.split("-")[1];
                    let count = parseInt($("#count-"+shopCartId).val());
                    let price = parseFloat($("#price-"+shopCartId).val());
                    sumCost += price*count;
                    checkCount += count;
                }
            })
            $("#checkedCount").val(checkCount)  ;
            $("#allCost").val(sumCost) ;
        }),

        $("#bill").click(function () {
            let arr = [];
            let car = {};
            $("[id^=check-]").each(function () {
                if(this.checked){
                    let id = this.id.split("-")[1];
                    let count = $("#count-"+id).val();
                    car = {id,count};
                    arr.push(car)
                }
            });
            console.log(arr);
            $("#cartInfo").val(JSON.stringify(arr));
            $("#cartForm").submit();

        })
    })
    function del(id) {
        if (confirm("确定删除")) {
            location.href = "delshopItem?id="+id;
        } else {
            alert("取消删除");
        }
    }
</script>
</body>
</html>