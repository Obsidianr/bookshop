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
    <div>
        <jsp:include page="top.jsp"></jsp:include>
        <div style="background: #eaeaea;width: 90%;margin: 10px;height: 600px">
            <table class="layui-table" style="padding:10px">
                <thead>
                <tr>
                    <th>管理员编号</th>
                    <th>姓名</th>
                    <th>电话</th>
                    <th>密码</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="admin" items="${AdminList}" varStatus="vs" >
                    <tr>
                        <td>${admin.id}</td>
                        <td>${admin.name}</td>
                        <td>${admin.tel}</td>
                        <td>${admin.password}</td>
                        <td>
                            <button  class="layui-btn" onclick="update(${admin.id})">编辑</button>
                            <button  class="layui-btn" onclick="firm(${admin.id})">删除</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        ${Msg}
    </div>
</div>
<script src="//res.layui.com/layui/dist/layui.js" charset="utf-8"></script>
<script language="javascript">
    function firm(id) {//利用对话框返回的值 （true 或者 false）
        if (confirm("确定删除")) {
            location.href = "delAdmin?id="+id;
        } else {
            alert("取消删除");
        }
    }
    function update(id) {
        location.href = "updateAdminPage?id="+id;
    }
</script>
<%--<script>--%>
<%--    layui.use(['laypage', 'layer'], function() {--%>
<%--        var laypage = layui.laypage--%>
<%--            , layer = layui.layer;--%>

<%--        //总页数低于页码总数--%>
<%--        laypage.render({--%>
<%--            elem: 'demo0'--%>
<%--            , count: 50 //数据总数--%>
<%--        });--%>
<%--    });--%>
<%--</script>--%>
</body>
</html>