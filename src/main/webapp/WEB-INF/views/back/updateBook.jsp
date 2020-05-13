<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:c="http://java.sun.com/jsp/jstl/core">
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
        <div style="background: #eaeaea;display: flex;padding-top: 10px">
            <form class="layui-form" action="updateBook" >
                <div style="display: flex;margin-left: 20px ">
                    <div>
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">书籍编号</label>
                                <div class="layui-input-inline">
                                    <input  name="bId" class="layui-input" lay-verify="required" value="${book.bId}"  >
                                </div>
                            </div>
                        </div>
                        <div class="layui-form-item" >
                            <label class="layui-form-label">类型</label>
                            <div class="layui-input-block" style="width: 190px">
                                <select name="type" lay-filter="aihao">
                                    <option value=""></option>
                                    <option value="0">写作</option>
                                    <option value="1" selected="">阅读</option>
                                    <option value="2">游戏</option>
                                    <option value="3">音乐</option>
                                    <option value="4">旅行</option>
                                </select>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">书名</label>
                                <div class="layui-input-inline">
                                    <input type="tel" name="bookName" value="${book.bookName}" class="layui-input" lay-verify="required">
                                </div>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">作者</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="author" value="${book.author}"  class="layui-input">
                                </div>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">出版社</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="publisher" value="${book.publisher}"  class="layui-input" lay-verify="required">
                                </div>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">价格</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="price"  value="${book.price}" class="layui-input" lay-verify="required">
                                </div>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">库存</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="count" value="${book.count}" class="layui-input" lay-verify="required">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div style="margin-left: 20px">
                        <div class="layui-form-item">
                            <label class="layui-form-label">书籍图片</label>
                            <div class="layui-upload">
                                <button type="button" class="layui-btn" id="pic">上传图片</button>
                                <div class="layui-input-block" style="margin-top: 5px">
                                    <img class="layui-upload-img" id="demo1" name="picture" src="imgs/${book.img}" style="height: 200px;width: 200px">
                                    <p id="demoText"></p>
                                    <input name="img" value="${book.img}" hidden="hidden">
                                </div>
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">书籍详情</label>
                            <div class="layui-input-block" >
                                <textarea  class="layui-textarea" name="describe" style="width: 500px;height: 300px">${book.describe} </textarea>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="layui-form-item" style="text-align: center">
                    <div class="layui-input-block">
                        <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">确定修改</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
            ${errorMsg}
        </div>
    </div>
</div>

<script>
    layui.use(['form', 'layedit', 'laydate','upload'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate
            ,$ = layui.jquery
            ,upload = layui.upload;
        //普通图片上传
        var uploadInst = upload.render({
            elem: '#pic'
            ,url: 'upload' //改成您自己的上传接口
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#demo1').attr('src', result); //图片链接（base64）
                });
            }
            ,done: function(res){
                //如果上传失败
                if(res.code > 0){
                    return layer.msg('上传失败');
                }
                //上传成功
                if(res.code == 0){
                    return layer.msg('上传成功');
                }
            }
            ,error: function(){
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }
        });
    });
</script>
</body>
</html>