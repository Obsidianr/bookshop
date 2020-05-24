<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:c="http://java.sun.com/jsp/jstl/core" >
<head>
    <meta charset="UTF-8">
    <title>首页</title>
</head>
<%--<link rel="stylesheet" href="/layui/css/layui.css">--%>
<%--<script type="text/javascript" src="/layui/layui.js"></script>--%>
<style>
    #loginBtn:hover {
        color: red;
        cursor: pointer;
    }

    .typeBtn:hover{
        color: red;
        cursor: pointer;
    }
    .bookitem:hover{
        cursor: pointer;
    }
</style>
<body>
<jsp:include page="front/frontTop.jsp"></jsp:include>
<div style="display: flex;margin: 20px 150px;" >
    <div id="booktype" style="width: 20%;border: solid lightgray 1px;background: #9F9F9F">
        <div class="typeBtn" id = "type-1" style="padding: 10px; text-align: center; border: solid lightgray 1px" ><h3>教  育</h3></div>
        <div class="typeBtn" id = "type-2"  style="padding: 10px; text-align: center;border: solid lightgray 1px"><h3>文  学</h3></div>
        <div class="typeBtn" id = "type-3"  style="padding: 10px; text-align: center;border: solid lightgray 1px"><h3>科  技</h3></div>
        <div class="typeBtn" id = "type-4"  style="padding: 10px; text-align: center;border: solid lightgray 1px"><h3>人  文</h3></div>
        <div class="typeBtn" id = "type-5"  style="padding: 10px; text-align: center;border: solid lightgray 1px"><h3>儿  童</h3></div>
    </div>
    <div style="width: 80%;display: flex;padding: 20px 10px;flex-wrap: wrap" id="bookdiv">
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="layui/layui.js"></script>
<script >
    layui.use(['layer'], function(){
        var layer = layui.layer

        $("[id^=type-]").click(function () {

            $("[id^=type-]").css({backgroundColor: "9F9F9F"})
            $(this).css({backgroundColor:"white"})
            let id = this.id.split("-")[1]
            $.post('showBook?id='+id, {}, function (res) {
                console.log(res)
                let bookdiv =  $("#bookdiv");
                bookdiv.empty()
                if(res.res){
                    let data = res.data;
                    for(let x=0; x<data.length; x++){
                        let book = data[x];
                        let bookItem = $(
                            "<div class=\"bookitem\" style=\" width: 20%; padding: 10px;border: solid lightgray 1px;box-shadow: 0 0 4px lightgray;margin: 5px \">\n" +
                            "            <div style=\"text-align: center\"><img src='"+ book.img + "'></div>\n" +
                            "            <div style=\"padding: 2px;cursor: pointer\">"+book.bookName+" </div>\n" +
                            "            <div style=\"padding: 2px;color: lightgray;font-size: 12px\">"+book.publisher+"</div>\n" +
                            "            <div style=\"color: orangered\">¥<span style=\"font-size: 20px\">"+book.price+"</span></div>\n" +
                            "        </div>");
                        bookdiv.append(bookItem);
                        bookItem.click(function () {
                            window.location="bookDetail?id="+book.bId;
                        })
                    }
                }
            })
        });
        $("[id^=type-]:eq(0)").click()


    })

</script>
</body>
</html>