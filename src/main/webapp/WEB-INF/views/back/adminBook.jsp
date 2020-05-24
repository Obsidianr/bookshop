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
        <div style="background: #eaeaea;height: 600px;margin: 10px">
            <table class="layui-table">
                <colgroup>
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th>书籍编号</th>
                    <th>类型</th>
                    <th>书名</th>
                    <th>作者</th>
                    <th>出版商</th>
                    <th>库存</th>
                    <th>价格</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="book" items="${BList}" varStatus="vs" >
                    <tr>
                        <td>${book.bId}</td>
                        <td>${book.type}</td>
                        <td>${book.bookName}</td>
                        <td>${book.author}</td>
                        <td>${book.publisher}</td>
                        <td>${book.stock}</td>
                        <td>${book.price}</td>
                        <td>
                            <div class="layui-btn-group">
                                <button  class="layui-btn" onclick="bookDetail(${book.bId})">查看</button>
                                <button  class="layui-btn" onclick="update(${book.bId})">编辑</button>
                                <button  class="layui-btn" onclick="firm(${book.bId})">删除</button>
                            </div>
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
            location.href = "delBook?id="+id;
        } else {
            alert("取消删除");
        }
    }
    function update(id) {
        location.href = "updateBookPage?id="+id;
    }
    function bookDetail(id) {
        location.href = "bookDetail?id="+id;
    }
</script>

</body>
</html>