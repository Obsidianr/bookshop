<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:c="http://java.sun.com/jsp/jstl/core" >
<head>
    <meta charset="UTF-8">
    <title>首页</title>
</head>
<style>
    #loginBtn:hover {
        color: red;
        cursor: pointer;
    }

    .typeBtn:hover {
        color: red;
        cursor: pointer;
    }
</style>
<body>

<div style="display: flex;padding-bottom: 5px;align-items: center">
    <div style="width: 35%;margin-left: 40px">
        <div style="display: flex;background:#86c5fa;width: 140px">
            <img src="/imgs/logo.jpg" style="width: 40px;height: 40px">
            <span style="font-size: 140%;margin-top: 8px;color: aliceblue">小瓜书店</span>
        </div>
    </div>
    <div style="width: 50%;display: flex;border: solid blue">
        <div style="width: 80%">
            <input type="text" style="height: 30px;width: 100%">
        </div>
        <div style="color: aliceblue;background: darkblue;padding: 5px 20px;width: 20%;text-align: center">
            搜索
        </div>
    </div>
    <div style="cursor: pointer; color: darkblue;width: 20%;text-align: center;background: darkgray;border: solid lightgray 1px;padding: 5px;margin-left: 30px;margin-right: 30px">
        我的购物车(1)
    </div>
    <div id="loginBtn" onclick="window.location='loginPage'" style=" width: 50px;text-align: center;background: darkgray;border: solid lightgray 1px;padding: 5px;margin-left: 30px;margin-right: 30px">
        登录
    </div>
</div>

<div style="display: flex;margin: 20px 150px">
    <div style="width: 20%;border: solid lightgray 1px;background: #9F9F9F">
        <div class="typeBtn" style="padding: 10px; text-align: center; border: solid lightgray 1px" onclick="selecttype(1)"><h3>教  育</h3></div>
        <div class="typeBtn" style="padding: 10px; text-align: center;border: solid lightgray 1px" onclick="selecttype(2)"><h3>文  学</h3></div>
        <div class="typeBtn" style="padding: 10px; text-align: center;border: solid lightgray 1px" onclick="selecttype(3)"><h3>科  技</h3></div>
        <div class="typeBtn" style="padding: 10px; text-align: center;border: solid lightgray 1px" onclick="selecttype(4)"><h3>人  文</h3></div>
        <div class="typeBtn" style="padding: 10px; text-align: center;border: solid lightgray 1px" onclick="selecttype(5)"><h3>儿  童</h3></div>


    </div>
    <div style="width: 80%;display: flex;padding: 20px 10px;border: solid red">
        <div style=" width: 25%; padding: 10px;border: solid lightgray 1px;box-shadow: 0 0 4px lightgray;margin: 5px ">
            <div style="text-align: center"><img src="/imgs/book.jpg"></div>
            <div style="padding: 2px;cursor: pointer">高等数学(第七版) </div>
            <div style="padding: 2px;color: lightgray;font-size: 12px">高等教育出版社</div>
            <div style="color: orangered">¥<span style="font-size: 20px">15</span></div>

        </div>
        <div style=" width: 25%; padding: 10px;border: solid lightgray 1px;box-shadow: 0 0 4px lightgray;margin: 5px ">
            <div><img src="/imgs/book.jpg"></div>
            <div style="padding: 2px;cursor: pointer">高等数学(第七版) </div>
            <div style="padding: 2px;color: lightgray;font-size: 12px">高等教育出版社</div>
            <div style="color: orangered">¥<span style="font-size: 20px">15</span></div>

        </div>
        <div style=" width: 25%; padding: 10px;border: solid lightgray 1px;box-shadow: 0 0 4px lightgray;margin: 5px ">
            <div><img src="/imgs/book.jpg"></div>
            <div style="padding: 2px;cursor: pointer">高等数学(第七版) </div>
            <div style="padding: 2px;color: lightgray;font-size: 12px">高等教育出版社</div>
            <div style="color: orangered">¥<span style="font-size: 20px">15</span></div>

        </div>
        <div style=" width: 25%; padding: 10px;border: solid lightgray 1px;box-shadow: 0 0 4px lightgray;margin: 5px ">
            <div><img src="/imgs/book.jpg"></div>
            <div style="padding: 2px;cursor: pointer">高等数学(第七版) </div>
            <div style="padding: 2px;color: lightgray;font-size: 12px">高等教育出版社</div>
            <div style="color: orangered">¥<span style="font-size: 20px">15</span></div>

        </div>
    </div>
</div>
</body>
</html>