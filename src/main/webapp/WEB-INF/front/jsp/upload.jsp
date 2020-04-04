<%--
  Created by IntelliJ IDEA.
  User: junlong
  Date: 2019-11-16
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
    <%String path = request.getContextPath();%>
<%--    <link rel="stylesheet" type="text/css" href="../js/layui/css/layui.css"/>--%>
<%--    <script type="text/javascript" src="../js/layui/layui.js"></script>--%>
    <link rel="stylesheet" href=<%=path+"/layui/css/layui.css" %> media="all">
    <script src="<%=request.getContextPath()%>/layui/layui.js"></script>
    <script src="<%=request.getContextPath()%>/front/js/jquery-3.4.1.js"></script>
    <script src="<%=request.getContextPath()%>/front/js/upload.js"></script>
</head>
<style>

    .layui-form {
        margin-top: 5%;
        margin-left: 30%;
        padding: 2%;
        width: 35%;
        background-color: #dadada;

    }


</style>
<body>
<input type="hidden" id="path" value="<%=path%>">
<div class="layui-progress layui-progress-big" lay-showpercent="true" lay-filter="demo">
    <div class="layui-progress-bar layui-bg-red" lay-percent="0%"></div>
</div>
<div class="layui-form" action="" lay-filter="example">
    <div class="layadmin-user-login-box layadmin-user-login-header">
        <h2>文件上传</h2>
    </div>
    <div class="layui-inline" style="width:500px;">
        <hr>
    </div>
    <div class="layadmin-user-login-box layadmin-user-login-header">
        <div class="layui-form-item">
            <label class="layui-form-label">文档标题：</label>
            <div class="layui-input-inline">
                <input type="text" name="title" id="hideBookName" required  lay-verify="title"  autocomplete="off"
                       class="layui-input"style="width: 300px" >
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">文件简介：</label>
            <div class="layui-input-block">
                <textarea name="intro" placeholder="请输入内容" id="intro" required  class="layui-textarea" style="width: 300px"></textarea>
            </div>
        </div>
        <div class="layadmin-user-login-box layadmin-user-login-header">
            <div class="layui-form-item">
                <label class="layui-form-label">下载积分：</label>
                <div class="layui-input-inline">
                    <input type="text"  onkeyup="value=value.replace(/^(0+)|[^\d]+/g,'')" name="downscore" id="downScore" required  lay-verify="title"  autocomplete="off"
                           class="layui-input"style="width: 300px" >
                </div>
            </div>
        </div>
        <div class="layadmin-user-login-box layadmin-user-login-header">
            <div class="layui-form-item">
                <label class="layui-form-label">选择文件：</label>
                <div class="layui-input-inline">
                    <label type="text" id="fileName"   required  lay-verify="title"  autocomplete="off"
                           class="layui-input"style="width: 200px" ></label>
                </div>
                <button type="button" class="layui-btn layui-btn-normal" id="test8" style="margin-left: 10px;">选择文件</button>
            </div>
        </div>
    </div>
        <div class="demoTable">
            <div style="padding-bottom: 10px;">
                <div class="layui-upload">
                    <button type="button" class="layui-btn" id="test9" style="margin-left: 160px;">上传</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
