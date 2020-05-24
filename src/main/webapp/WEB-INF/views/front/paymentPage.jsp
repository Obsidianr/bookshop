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
<div class="layui-row">
    <div class="layui-col-xs6 layui-col-sm6 layui-col-md4 layui-col-md-offset4">
        <div class="grid-demo l">
            <div style="justify-content: center;padding: 20px;border-radius: 10px;box-shadow: 0 0 10px #1E9FFF;margin-top: 13%">

                <span style="font-size: x-large;color: red;margin-left: 20%">¥${cost}</span>

                <div style="display: flex">
                    <div>
                        <div style="margin: 10px 20px"><button class="layui-btn layui-btn-danger" id="pay" style="background: red">确认付款</button></a> </div>
                    </div>
                    <div>
                        <div style="margin: 10px 20px"> <button class="layui-btn layui-btn-danger" id="cancel" style="background: red">取消付款</button></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
</div>

<div class="layui-row" style="margin-top: 20px">
    <div class="layui-col-xs6 layui-col-md10 layui-col-md-offset2 " >



    </div>
</div>


<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="layui/layui.js"></script>
 <script>
    layui.use(['layer'], function(){
        var layer = layui.layer
        $("#pay").click( function () {
            alert("付款成功！返回首页");
            location.href="/"
        });
        $("#cancel").click( function () {
            alert("取消付款！返回首页");
            location.href="/"
        });
    })
</script>

</body>
</html>