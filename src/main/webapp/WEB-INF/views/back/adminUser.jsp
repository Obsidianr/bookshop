<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<link rel="stylesheet" href="/layui/css/layui.css">
<script type="text/javascript" src="/layui/layui.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<body style="background:#393D49">

<div style="display: flex">
    <jsp:include page="left.jsp"></jsp:include>
    <div>
        <jsp:include page="top.jsp"></jsp:include>
        <div style="background: #eaeaea;width: 90%;margin: 10px;height: 600px">
            <table class="layui-table" style="padding:10px">
                <thead>
                <tr>
                    <th>用户编号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>电话</th>
                    <th>密码</th>
                    <th>地址</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${UList}" varStatus="vs" >
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.gende}</td>
                        <td>${user.tel}</td>
                        <td>${user.password}</td>
                        <td>${user.adress}</td>
                        <td>
                            <button  class="layui-btn" onclick="update(${user.id})">编辑</button>
                            <button  class="layui-btn" onclick="firm(${user.id})">删除</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            ${Msg}
        </div>
    </div>
</div>

<script language="javascript">
    function firm(id) {//利用对话框返回的值 （true 或者 false）
        if (confirm("确定删除")) {//如果是true ，那么就把页面转向https://blog.csdn.net/h2503652646
            location.href = "delUser?id="+id;
        } else {
            alert("取消删除");
        }
    }
    function update(id) {
        location.href = "updateUserPage?id="+id;
    }
</script>
</body>
</html>