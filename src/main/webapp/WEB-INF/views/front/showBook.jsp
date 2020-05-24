<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<link rel="stylesheet" href="/layui/css/layui.css">
<script type="text/javascript" src="/layui/layui.js"></script>
<body class="layui-col-xs6 layui-col-md8 layui-col-md-offset2">
<jsp:include page="frontTop.jsp" flush="true"></jsp:include>
<div class="layui-row">
    <div class="layui-col-xs12 layui-col-md4 layui-col-md-offset2">
        <div class="grid-demo grid-demo-bg1">
            <div style="margin: 10px;border: solid lightgray 1px;box-shadow: 0 0 4px lightgray;">
                <img src="${book.img}" style="width: 300px;height: 300px">
            </div>
        </div>
    </div>
    <div class="layui-col-xs6 layui-col-md4" >
        <div class="grid-demo"style="margin-top: 30px;margin-left: 10px;margin-bottom: 10px" >
            <div style="margin: 10px"><h1>${book.bookName}</h1></div>
            <div style="background: #eaeaea;padding: 5px">
                <div style="margin: 10px" style="display: flex"><span style="font-size: larger;color: #9F9F9F">作者: ${book.author}</span></div>
                <div style="margin: 10px" style="display: flex"><span style="font-size: larger;color: #9F9F9F">出版社: ${book.publisher}</span></div>
                <div style="margin: 10px" style="display: flex"><span style="font-size: larger;color: #9F9F9F">库存: ${book.stock}</span></div>
                <div style="margin: 10px" style="display: flex">
                    <span style="font-size: larger;color: #616161">价格: </span>
                    <span style="color: orangered;font-size:xx-large">¥${book.price}</span>
                </div>
                <div style="margin: 10px" style="display: flex"><span style="font-size: smaller;color: #9F9F9F">温馨提示：本商品支持7天无理由退货</span></div>
            </div>

        </div>
        <div style="margin: 10px;display: flex">
            <div > <button class="layui-btn layui-btn-danger" onclick="shopcart(${book.bId})">加入购物车</button></div>
            <div style="margin-left: 20px"> <button class="layui-btn layui-btn-danger" onclick="buy(${book.bId})">立即购买</button></div>
        </div>
    </div>
    <div class="layui-col-xs6 layui-col-md8 layui-col-md-offset2 " >
        <div class="grid-demo grid-demo-bg2" style="border: solid gainsboro 1px;margin: 10px;padding: 10px">${book.describe}</div>
    </div>
    ${Msg}
</div>
<script>
function shopcart(bid) {

    window.location="addShopToCart?id="+bid
}
</script>
</body>
</html>