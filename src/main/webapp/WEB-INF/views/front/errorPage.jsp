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
       <div style="display: flex;justify-content: center;margin-top: 13%">${Msg}</div>
    </div>
</div>


<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="layui/layui.js"></script>
<script >

</script>
</body>
</html>